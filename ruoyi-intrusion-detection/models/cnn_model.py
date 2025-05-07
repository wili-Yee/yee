import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import Dataset, DataLoader
import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder, StandardScaler
from sklearn.metrics import precision_score, recall_score, f1_score, classification_report, confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt
import os
import sys


# 自定义网络攻击流量数据集类
class MyDataset(Dataset):
    def __init__(self, data, label):
        assert isinstance(data, np.ndarray), "data must be a numpy array"
        assert isinstance(label, (np.ndarray, list)), "label must be a numpy array or list"

        # 将标签编码为整数
        if isinstance(label[0], str):  # 如果标签是字符串
            le = LabelEncoder()
            label = le.fit_transform(label)

        self.data = data
        self.label = label
        self.length = len(self.data)

    def __getitem__(self, index):
        data = self.data[index]
        label = self.label[index]
        return data, label

    def __len__(self):
        return self.length

    def collate_fn(self, batch):
        data, label = zip(*batch)
        data = np.array(data)  # 将列表转换为单个numpy.ndarray
        label = np.array(label)  # 将列表转换为单个numpy.ndarray
        data = torch.tensor(data, dtype=torch.float32)
        label = torch.tensor(label, dtype=torch.long)  # 确保label是一维的
        return data, label


# 定义CNN模型
class CNNAttackDetector(nn.Module):
    def __init__(self, input_size, num_classes=2):
        super(CNNAttackDetector, self).__init__()
        self.conv1 = nn.Conv1d(1, 16, kernel_size=3, padding=1)
        self.relu1 = nn.ReLU()
        self.pool1 = nn.MaxPool1d(kernel_size=2)
        self.conv2 = nn.Conv1d(16, 32, kernel_size=3, padding=1)
        self.relu2 = nn.ReLU()
        self.pool2 = nn.MaxPool1d(kernel_size=2)
        self.fc1 = nn.Linear(32 * (input_size // 4), 128)
        self.relu3 = nn.ReLU()
        self.fc2 = nn.Linear(128, num_classes)

    def forward(self, x):
        x = x.unsqueeze(1)  # 添加通道维度 [batch_size, 1, input_size]
        x = self.pool1(self.relu1(self.conv1(x)))
        x = self.pool2(self.relu2(self.conv2(x)))
        x = x.view(x.size(0), -1)  # 展平
        x = self.relu3(self.fc1(x))
        x = self.fc2(x)
        return x


# 训练模型函数
def train_model(model, train_loader, criterion, optimizer, epochs, device):
    model.train()
    for epoch in range(epochs):
        running_loss = 0.0
        for inputs, labels in train_loader:
            inputs, labels = inputs.to(device), labels.to(device)

            optimizer.zero_grad()
            outputs = model(inputs)
            loss = criterion(outputs, labels)
            loss.backward()
            optimizer.step()

            running_loss += loss.item()

        print(f'Epoch {epoch+1}/{epochs}, Loss: {running_loss/len(train_loader):.4f}')


# 评估模型函数
def evaluate_model(model, test_loader, device):
    model.eval()
    correct = 0
    total = 0
    all_labels = []
    all_preds = []

    with torch.no_grad():
        for inputs, labels in test_loader:
            inputs, labels = inputs.to(device), labels.to(device)
            outputs = model(inputs)
            _, predicted = torch.max(outputs.data, 1)
            total += labels.size(0)
            correct += (predicted == labels).sum().item()

            all_labels.extend(labels.cpu().numpy())
            all_preds.extend(predicted.cpu().numpy())

    accuracy = 100 * correct / total
    print(f'Accuracy: {accuracy:.2f}%')

    # 计算其他评估指标
    precision = precision_score(all_labels, all_preds, average='weighted')
    recall = recall_score(all_labels, all_preds, average='weighted')
    f1 = f1_score(all_labels, all_preds, average='weighted')

    print(f'Precision: {precision:.4f}, Recall: {recall:.4f}, F1-Score: {f1:.4f}')

    # 打印分类报告
    print("Classification Report:")
    print(classification_report(all_labels, all_preds))

    return accuracy, precision, recall, f1


# 运行模型检测
def run_model(file_path, selected_model):
    # 这里应该实现加载数据、预处理、模型推理的完整流程
    # 为简化示例，这里只返回模拟结果
    import random

    # 模拟特征重要性
    features = ['feature1', 'feature2', 'feature3', 'feature4', 'feature5']
    feature_importance = []

    for feature in features:
        score = round(random.uniform(0.1, 0.9), 4)
        status = 'normal' if score < 0.7 else 'abnormal'
        feature_importance.append({
            'feature': feature,
            'score': score,
            'status': status
        })

    # 模拟准确率
    accuracy = round(random.uniform(80, 95), 2)

    # 模拟流量分布
    total = 1000
    normal_traffic = int(total * random.uniform(0.6, 0.9))
    abnormal_traffic = total - normal_traffic

    return {
        'features': feature_importance,
        'accuracy': accuracy,
        'normal_traffic': normal_traffic,
        'abnormal_traffic': abnormal_traffic
    }


# 主函数示例
if __name__ == "__main__":
    # 设置设备
    device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')

    # 示例：创建模型
    input_size = 20  # 示例输入大小
    model = CNNAttackDetector(input_size).to(device)

    # 示例：定义损失函数和优化器
    criterion = nn.CrossEntropyLoss()
    optimizer = optim.Adam(model.parameters(), lr=0.001)

    # 示例：训练模型（需要准备数据集）
    # train_model(model, train_loader, criterion, optimizer, epochs=10, device=device)

    # 示例：评估模型（需要准备测试集）
    # evaluate_model(model, test_loader, device)

    # 示例：运行检测
    result = run_model("path/to/your/data.csv", "cnn")
    print(result)

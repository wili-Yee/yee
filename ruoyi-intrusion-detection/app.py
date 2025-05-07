from flask import Flask, jsonify, request
import subprocess
import json
import os
from models.cnn_model import run_model  # 假设cnn_model.py中有run_model函数

app = Flask(__name__)

@app.route('/')
def index():
    return jsonify({'message': '入侵检测服务已启动', 'status': 'running'})

@app.route('/favicon.ico')
def favicon():
    return '', 204

@app.route('/detect', methods=['POST'])
def detect():
    try:
        file = request.files.get('file')
        selected_model = request.form.get('model')
        if not file or not selected_model:
            return jsonify({'error': '文件或模型未选择'}), 400
        file_path = 'temp.csv'
        file.save(file_path)
        result = run_model(file_path, selected_model)
        os.remove(file_path)
        return jsonify(result)
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)

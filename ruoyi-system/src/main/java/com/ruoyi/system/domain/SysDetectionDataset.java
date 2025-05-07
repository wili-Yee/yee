package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测数据集信息对象 sys_detection_dataset
 * 
 * @author weimin
 * @date 2025-04-26
 */
public class SysDetectionDataset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据集 ID */
    private Long datasetId;

    /** 数据集名称 */
    @Excel(name = "数据集名称")
    private String datasetName;

    /** 数据集描述 */
    @Excel(name = "数据集描述")
    private String datasetDescription;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    /** 记录数 */
    @Excel(name = "记录数")
    private Long recordCount;

    /** 数据集状态（0 正常 1 停用） */
    @Excel(name = "数据集状态", readConverterExp = "0=,正=常,1=,停=用")
    private String status;

    public void setDatasetId(Long datasetId) 
    {
        this.datasetId = datasetId;
    }

    public Long getDatasetId() 
    {
        return datasetId;
    }

    public void setDatasetName(String datasetName) 
    {
        this.datasetName = datasetName;
    }

    public String getDatasetName() 
    {
        return datasetName;
    }

    public void setDatasetDescription(String datasetDescription) 
    {
        this.datasetDescription = datasetDescription;
    }

    public String getDatasetDescription() 
    {
        return datasetDescription;
    }

    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }

    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }

    public void setRecordCount(Long recordCount) 
    {
        this.recordCount = recordCount;
    }

    public Long getRecordCount() 
    {
        return recordCount;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("datasetId", getDatasetId())
            .append("datasetName", getDatasetName())
            .append("datasetDescription", getDatasetDescription())
            .append("filePath", getFilePath())
            .append("fileName", getFileName())
            .append("fileSize", getFileSize())
            .append("recordCount", getRecordCount())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}

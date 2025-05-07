package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模型信息对象 sys_model
 * 
 * @author ruoyi
 * @date 2025-04-26
 */
public class SysModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 模型 ID */
    private Long modelId;

    /** 模型名称 */
    @Excel(name = "模型名称")
    private String modelName;

    /** 模型描述 */
    @Excel(name = "模型描述")
    private String modelDescription;

    /** 模型状态（0 启用 1 停用） */
    @Excel(name = "模型状态", readConverterExp = "0=,启=用,1=,停=用")
    private String status;

    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }

    public void setModelName(String modelName) 
    {
        this.modelName = modelName;
    }

    public String getModelName() 
    {
        return modelName;
    }

    public void setModelDescription(String modelDescription) 
    {
        this.modelDescription = modelDescription;
    }

    public String getModelDescription() 
    {
        return modelDescription;
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
            .append("modelId", getModelId())
            .append("modelName", getModelName())
            .append("modelDescription", getModelDescription())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("status", getStatus())
            .toString();
    }
}

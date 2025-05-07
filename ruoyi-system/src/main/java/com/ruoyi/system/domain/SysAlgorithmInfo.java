package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 算法信息对象 sys_algorithm_info
 * 
 * @author ｗｅｉｍｉｎ
 * @date 2025-04-26
 */
public class SysAlgorithmInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 算法 ID */
    private Long algorithmId;

    /** 算法名称 */
    @Excel(name = "算法名称")
    private String algorithmName;

    /** 算法描述 */
    @Excel(name = "算法描述")
    private String algorithmDescription;

    /** 算法状态（0 启用 1 停用） */
    @Excel(name = "算法状态", readConverterExp = "0=,启=用,1=,停=用")
    private String status;

    public void setAlgorithmId(Long algorithmId) 
    {
        this.algorithmId = algorithmId;
    }

    public Long getAlgorithmId() 
    {
        return algorithmId;
    }

    public void setAlgorithmName(String algorithmName) 
    {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName() 
    {
        return algorithmName;
    }

    public void setAlgorithmDescription(String algorithmDescription) 
    {
        this.algorithmDescription = algorithmDescription;
    }

    public String getAlgorithmDescription() 
    {
        return algorithmDescription;
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
            .append("algorithmId", getAlgorithmId())
            .append("algorithmName", getAlgorithmName())
            .append("algorithmDescription", getAlgorithmDescription())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}

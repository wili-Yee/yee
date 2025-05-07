package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysDetectionDataset;

/**
 * 检测数据集信息Service接口
 * 
 * @author weimin
 * @date 2025-04-26
 */
public interface ISysDetectionDatasetService 
{
    /**
     * 查询检测数据集信息
     * 
     * @param datasetId 检测数据集信息主键
     * @return 检测数据集信息
     */
    public SysDetectionDataset selectSysDetectionDatasetByDatasetId(Long datasetId);

    /**
     * 查询检测数据集信息列表
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 检测数据集信息集合
     */
    public List<SysDetectionDataset> selectSysDetectionDatasetList(SysDetectionDataset sysDetectionDataset);

    /**
     * 新增检测数据集信息
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 结果
     */
    public int insertSysDetectionDataset(SysDetectionDataset sysDetectionDataset);

    /**
     * 修改检测数据集信息
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 结果
     */
    public int updateSysDetectionDataset(SysDetectionDataset sysDetectionDataset);

    /**
     * 批量删除检测数据集信息
     * 
     * @param datasetIds 需要删除的检测数据集信息主键集合
     * @return 结果
     */
    public int deleteSysDetectionDatasetByDatasetIds(Long[] datasetIds);

    /**
     * 删除检测数据集信息信息
     * 
     * @param datasetId 检测数据集信息主键
     * @return 结果
     */
    public int deleteSysDetectionDatasetByDatasetId(Long datasetId);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDetectionDatasetMapper;
import com.ruoyi.system.domain.SysDetectionDataset;
import com.ruoyi.system.service.ISysDetectionDatasetService;

/**
 * 检测数据集信息Service业务层处理
 * 
 * @author weimin
 * @date 2025-04-26
 */
@Service
public class SysDetectionDatasetServiceImpl implements ISysDetectionDatasetService 
{
    @Autowired
    private SysDetectionDatasetMapper sysDetectionDatasetMapper;

    /**
     * 查询检测数据集信息
     * 
     * @param datasetId 检测数据集信息主键
     * @return 检测数据集信息
     */
    @Override
    public SysDetectionDataset selectSysDetectionDatasetByDatasetId(Long datasetId)
    {
        return sysDetectionDatasetMapper.selectSysDetectionDatasetByDatasetId(datasetId);
    }

    /**
     * 查询检测数据集信息列表
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 检测数据集信息
     */
    @Override
    public List<SysDetectionDataset> selectSysDetectionDatasetList(SysDetectionDataset sysDetectionDataset)
    {
        return sysDetectionDatasetMapper.selectSysDetectionDatasetList(sysDetectionDataset);
    }

    /**
     * 新增检测数据集信息
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 结果
     */
    @Override
    public int insertSysDetectionDataset(SysDetectionDataset sysDetectionDataset)
    {
        sysDetectionDataset.setCreateTime(DateUtils.getNowDate());
        return sysDetectionDatasetMapper.insertSysDetectionDataset(sysDetectionDataset);
    }

    /**
     * 修改检测数据集信息
     * 
     * @param sysDetectionDataset 检测数据集信息
     * @return 结果
     */
    @Override
    public int updateSysDetectionDataset(SysDetectionDataset sysDetectionDataset)
    {
        sysDetectionDataset.setUpdateTime(DateUtils.getNowDate());
        return sysDetectionDatasetMapper.updateSysDetectionDataset(sysDetectionDataset);
    }

    /**
     * 批量删除检测数据集信息
     * 
     * @param datasetIds 需要删除的检测数据集信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDetectionDatasetByDatasetIds(Long[] datasetIds)
    {
        return sysDetectionDatasetMapper.deleteSysDetectionDatasetByDatasetIds(datasetIds);
    }

    /**
     * 删除检测数据集信息信息
     * 
     * @param datasetId 检测数据集信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDetectionDatasetByDatasetId(Long datasetId)
    {
        return sysDetectionDatasetMapper.deleteSysDetectionDatasetByDatasetId(datasetId);
    }
}

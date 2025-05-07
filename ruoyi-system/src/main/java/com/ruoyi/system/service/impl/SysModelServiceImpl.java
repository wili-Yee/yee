package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysModelMapper;
import com.ruoyi.system.domain.SysModel;
import com.ruoyi.system.service.ISysModelService;

/**
 * 模型信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-26
 */
@Service
public class SysModelServiceImpl implements ISysModelService 
{
    @Autowired
    private SysModelMapper sysModelMapper;

    /**
     * 查询模型信息
     * 
     * @param modelId 模型信息主键
     * @return 模型信息
     */
    @Override
    public SysModel selectSysModelByModelId(Long modelId)
    {
        return sysModelMapper.selectSysModelByModelId(modelId);
    }

    /**
     * 查询模型信息列表
     * 
     * @param sysModel 模型信息
     * @return 模型信息
     */
    @Override
    public List<SysModel> selectSysModelList(SysModel sysModel)
    {
        return sysModelMapper.selectSysModelList(sysModel);
    }

    /**
     * 新增模型信息
     * 
     * @param sysModel 模型信息
     * @return 结果
     */
    @Override
    public int insertSysModel(SysModel sysModel)
    {
        sysModel.setCreateTime(DateUtils.getNowDate());
        return sysModelMapper.insertSysModel(sysModel);
    }

    /**
     * 修改模型信息
     * 
     * @param sysModel 模型信息
     * @return 结果
     */
    @Override
    public int updateSysModel(SysModel sysModel)
    {
        sysModel.setUpdateTime(DateUtils.getNowDate());
        return sysModelMapper.updateSysModel(sysModel);
    }

    /**
     * 批量删除模型信息
     * 
     * @param modelIds 需要删除的模型信息主键
     * @return 结果
     */
    @Override
    public int deleteSysModelByModelIds(Long[] modelIds)
    {
        return sysModelMapper.deleteSysModelByModelIds(modelIds);
    }

    /**
     * 删除模型信息信息
     * 
     * @param modelId 模型信息主键
     * @return 结果
     */
    @Override
    public int deleteSysModelByModelId(Long modelId)
    {
        return sysModelMapper.deleteSysModelByModelId(modelId);
    }
}

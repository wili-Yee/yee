package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysModel;

/**
 * 模型信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-26
 */
public interface SysModelMapper 
{
    /**
     * 查询模型信息
     * 
     * @param modelId 模型信息主键
     * @return 模型信息
     */
    public SysModel selectSysModelByModelId(Long modelId);

    /**
     * 查询模型信息列表
     * 
     * @param sysModel 模型信息
     * @return 模型信息集合
     */
    public List<SysModel> selectSysModelList(SysModel sysModel);

    /**
     * 新增模型信息
     * 
     * @param sysModel 模型信息
     * @return 结果
     */
    public int insertSysModel(SysModel sysModel);

    /**
     * 修改模型信息
     * 
     * @param sysModel 模型信息
     * @return 结果
     */
    public int updateSysModel(SysModel sysModel);

    /**
     * 删除模型信息
     * 
     * @param modelId 模型信息主键
     * @return 结果
     */
    public int deleteSysModelByModelId(Long modelId);

    /**
     * 批量删除模型信息
     * 
     * @param modelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysModelByModelIds(Long[] modelIds);
}

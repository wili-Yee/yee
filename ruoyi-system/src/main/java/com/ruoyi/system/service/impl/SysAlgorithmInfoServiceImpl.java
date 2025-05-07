package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAlgorithmInfoMapper;
import com.ruoyi.system.domain.SysAlgorithmInfo;
import com.ruoyi.system.service.ISysAlgorithmInfoService;

/**
 * 算法信息Service业务层处理
 * 
 * @author ｗｅｉｍｉｎ
 * @date 2025-04-26
 */
@Service
public class SysAlgorithmInfoServiceImpl implements ISysAlgorithmInfoService 
{
    @Autowired
    private SysAlgorithmInfoMapper sysAlgorithmInfoMapper;

    /**
     * 查询算法信息
     * 
     * @param algorithmId 算法信息主键
     * @return 算法信息
     */
    @Override
    public SysAlgorithmInfo selectSysAlgorithmInfoByAlgorithmId(Long algorithmId)
    {
        return sysAlgorithmInfoMapper.selectSysAlgorithmInfoByAlgorithmId(algorithmId);
    }

    /**
     * 查询算法信息列表
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 算法信息
     */
    @Override
    public List<SysAlgorithmInfo> selectSysAlgorithmInfoList(SysAlgorithmInfo sysAlgorithmInfo)
    {
        return sysAlgorithmInfoMapper.selectSysAlgorithmInfoList(sysAlgorithmInfo);
    }

    /**
     * 新增算法信息
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 结果
     */
    @Override
    public int insertSysAlgorithmInfo(SysAlgorithmInfo sysAlgorithmInfo)
    {
        sysAlgorithmInfo.setCreateTime(DateUtils.getNowDate());
        return sysAlgorithmInfoMapper.insertSysAlgorithmInfo(sysAlgorithmInfo);
    }

    /**
     * 修改算法信息
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 结果
     */
    @Override
    public int updateSysAlgorithmInfo(SysAlgorithmInfo sysAlgorithmInfo)
    {
        sysAlgorithmInfo.setUpdateTime(DateUtils.getNowDate());
        return sysAlgorithmInfoMapper.updateSysAlgorithmInfo(sysAlgorithmInfo);
    }

    /**
     * 批量删除算法信息
     * 
     * @param algorithmIds 需要删除的算法信息主键
     * @return 结果
     */
    @Override
    public int deleteSysAlgorithmInfoByAlgorithmIds(Long[] algorithmIds)
    {
        return sysAlgorithmInfoMapper.deleteSysAlgorithmInfoByAlgorithmIds(algorithmIds);
    }

    /**
     * 删除算法信息信息
     * 
     * @param algorithmId 算法信息主键
     * @return 结果
     */
    @Override
    public int deleteSysAlgorithmInfoByAlgorithmId(Long algorithmId)
    {
        return sysAlgorithmInfoMapper.deleteSysAlgorithmInfoByAlgorithmId(algorithmId);
    }
}

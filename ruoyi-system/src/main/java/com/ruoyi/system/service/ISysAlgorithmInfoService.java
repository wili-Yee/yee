package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysAlgorithmInfo;

/**
 * 算法信息Service接口
 * 
 * @author ｗｅｉｍｉｎ
 * @date 2025-04-26
 */
public interface ISysAlgorithmInfoService 
{
    /**
     * 查询算法信息
     * 
     * @param algorithmId 算法信息主键
     * @return 算法信息
     */
    public SysAlgorithmInfo selectSysAlgorithmInfoByAlgorithmId(Long algorithmId);

    /**
     * 查询算法信息列表
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 算法信息集合
     */
    public List<SysAlgorithmInfo> selectSysAlgorithmInfoList(SysAlgorithmInfo sysAlgorithmInfo);

    /**
     * 新增算法信息
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 结果
     */
    public int insertSysAlgorithmInfo(SysAlgorithmInfo sysAlgorithmInfo);

    /**
     * 修改算法信息
     * 
     * @param sysAlgorithmInfo 算法信息
     * @return 结果
     */
    public int updateSysAlgorithmInfo(SysAlgorithmInfo sysAlgorithmInfo);

    /**
     * 批量删除算法信息
     * 
     * @param algorithmIds 需要删除的算法信息主键集合
     * @return 结果
     */
    public int deleteSysAlgorithmInfoByAlgorithmIds(Long[] algorithmIds);

    /**
     * 删除算法信息信息
     * 
     * @param algorithmId 算法信息主键
     * @return 结果
     */
    public int deleteSysAlgorithmInfoByAlgorithmId(Long algorithmId);
}

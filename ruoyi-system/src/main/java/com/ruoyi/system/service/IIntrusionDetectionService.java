package com.ruoyi.system.service;

import java.util.Map;

/**
 * 入侵检测服务接口
 */
public interface IIntrusionDetectionService {

    /**
     * 执行入侵检测
     * @param data 待检测的数据
     * @return 检测结果
     */
    Map<String, Object> detectIntrusion(Map<String, Object> data);
}

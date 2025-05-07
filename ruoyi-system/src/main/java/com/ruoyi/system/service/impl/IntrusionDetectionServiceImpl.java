package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.IIntrusionDetectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class IntrusionDetectionServiceImpl implements IIntrusionDetectionService {

    @Value("${intrusion.detection.api.url}")
    private String apiUrl;

    @Override
    public Map<String, Object> detectIntrusion(Map<String, Object> data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            Map<String, Object> errorResult = new HashMap<>();
            errorResult.put("success", false);
            errorResult.put("message", "入侵检测服务调用失败");
            return errorResult;
        }
    }
}

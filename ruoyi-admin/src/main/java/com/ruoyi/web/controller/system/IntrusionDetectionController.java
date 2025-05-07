package com.ruoyi.web.controller.system;



import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IIntrusionDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system/intrusion")
public class IntrusionDetectionController extends BaseController {

    @Autowired
    private IIntrusionDetectionService intrusionDetectionService;

    @PostMapping("/detect")
    public AjaxResult detect(@RequestBody Map<String, Object> data) {
        Map<String, Object> result = intrusionDetectionService.detectIntrusion(data);
        return AjaxResult.success(result);
    }
}

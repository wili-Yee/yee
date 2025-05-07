package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysAlgorithmInfo;
import com.ruoyi.system.service.ISysAlgorithmInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 算法信息Controller
 *
 * @author ｗｅｉｍｉｎ
 * @date 2025-04-26
 */
@RestController
@RequestMapping("/system/algorithm")
public class SysAlgorithmInfoController extends BaseController
{
    @Autowired
    private ISysAlgorithmInfoService sysAlgorithmInfoService;

    /**
     * 查询算法信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysAlgorithmInfo sysAlgorithmInfo)
    {
        startPage();
        List<SysAlgorithmInfo> list = sysAlgorithmInfoService.selectSysAlgorithmInfoList(sysAlgorithmInfo);
        return getDataTable(list);
    }

    /**
     * 导出算法信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:export')")
    @Log(title = "算法信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysAlgorithmInfo sysAlgorithmInfo)
    {
        List<SysAlgorithmInfo> list = sysAlgorithmInfoService.selectSysAlgorithmInfoList(sysAlgorithmInfo);
        ExcelUtil<SysAlgorithmInfo> util = new ExcelUtil<SysAlgorithmInfo>(SysAlgorithmInfo.class);
        util.exportExcel(response, list, "算法信息数据");
    }

    /**
     * 获取算法信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:query')")
    @GetMapping(value = "/{algorithmId}")
    public AjaxResult getInfo(@PathVariable("algorithmId") Long algorithmId)
    {
        return success(sysAlgorithmInfoService.selectSysAlgorithmInfoByAlgorithmId(algorithmId));
    }

    /**
     * 新增算法信息
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:add')")
    @Log(title = "算法信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysAlgorithmInfo sysAlgorithmInfo)
    {
        return toAjax(sysAlgorithmInfoService.insertSysAlgorithmInfo(sysAlgorithmInfo));
    }

    /**
     * 修改算法信息
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:edit')")
    @Log(title = "算法信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAlgorithmInfo sysAlgorithmInfo)
    {
        return toAjax(sysAlgorithmInfoService.updateSysAlgorithmInfo(sysAlgorithmInfo));
    }

    /**
     * 删除算法信息
     */
    @PreAuthorize("@ss.hasPermi('system:algorithm:remove')")
    @Log(title = "算法信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{algorithmIds}")
    public AjaxResult remove(@PathVariable Long[] algorithmIds)
    {
        return toAjax(sysAlgorithmInfoService.deleteSysAlgorithmInfoByAlgorithmIds(algorithmIds));
    }
}

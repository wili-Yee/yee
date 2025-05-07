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
import com.ruoyi.system.domain.SysDetectionDataset;
import com.ruoyi.system.service.ISysDetectionDatasetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测数据集信息Controller
 *
 * @author weimin
 * @date 2025-04-26
 */
@RestController
@RequestMapping("/system/dataset")
public class SysDetectionDatasetController extends BaseController
{
    @Autowired
    private ISysDetectionDatasetService sysDetectionDatasetService;

    /**
     * 查询检测数据集信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDetectionDataset sysDetectionDataset)
    {
        startPage();
        List<SysDetectionDataset> list = sysDetectionDatasetService.selectSysDetectionDatasetList(sysDetectionDataset);
        return getDataTable(list);
    }

    /**
     * 导出检测数据集信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:export')")
    @Log(title = "检测数据集信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDetectionDataset sysDetectionDataset)
    {
        List<SysDetectionDataset> list = sysDetectionDatasetService.selectSysDetectionDatasetList(sysDetectionDataset);
        ExcelUtil<SysDetectionDataset> util = new ExcelUtil<SysDetectionDataset>(SysDetectionDataset.class);
        util.exportExcel(response, list, "检测数据集信息数据");
    }

    /**
     * 获取检测数据集信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:query')")
    @GetMapping(value = "/{datasetId}")
    public AjaxResult getInfo(@PathVariable("datasetId") Long datasetId)
    {
        return success(sysDetectionDatasetService.selectSysDetectionDatasetByDatasetId(datasetId));
    }

    /**
     * 新增检测数据集信息
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:add')")
    @Log(title = "检测数据集信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDetectionDataset sysDetectionDataset)
    {
        return toAjax(sysDetectionDatasetService.insertSysDetectionDataset(sysDetectionDataset));
    }

    /**
     * 修改检测数据集信息
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:edit')")
    @Log(title = "检测数据集信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDetectionDataset sysDetectionDataset)
    {
        return toAjax(sysDetectionDatasetService.updateSysDetectionDataset(sysDetectionDataset));
    }

    /**
     * 删除检测数据集信息
     */
    @PreAuthorize("@ss.hasPermi('system:dataset:remove')")
    @Log(title = "检测数据集信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{datasetIds}")
    public AjaxResult remove(@PathVariable Long[] datasetIds)
    {
        return toAjax(sysDetectionDatasetService.deleteSysDetectionDatasetByDatasetIds(datasetIds));
    }
}

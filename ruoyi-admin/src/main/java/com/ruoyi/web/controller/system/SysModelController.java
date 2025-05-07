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
import com.ruoyi.system.domain.SysModel;
import com.ruoyi.system.service.ISysModelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模型信息Controller
 *
 * @author ruoyi
 * @date 2025-04-26
 */
@RestController
@RequestMapping("/system/model")
public class SysModelController extends BaseController
{
    @Autowired
    private ISysModelService sysModelService;

    /**
     * 查询模型信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysModel sysModel)
    {
        startPage();
        List<SysModel> list = sysModelService.selectSysModelList(sysModel);
        return getDataTable(list);
    }

    /**
     * 导出模型信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:model:export')")
    @Log(title = "模型信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysModel sysModel)
    {
        List<SysModel> list = sysModelService.selectSysModelList(sysModel);
        ExcelUtil<SysModel> util = new ExcelUtil<SysModel>(SysModel.class);
        util.exportExcel(response, list, "模型信息数据");
    }

    /**
     * 获取模型信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:model:query')")
    @GetMapping(value = "/{modelId}")
    public AjaxResult getInfo(@PathVariable("modelId") Long modelId)
    {
        return success(sysModelService.selectSysModelByModelId(modelId));
    }

    /**
     * 新增模型信息
     */
    @PreAuthorize("@ss.hasPermi('system:model:add')")
    @Log(title = "模型信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysModel sysModel)
    {
        return toAjax(sysModelService.insertSysModel(sysModel));
    }

    /**
     * 修改模型信息
     */
    @PreAuthorize("@ss.hasPermi('system:model:edit')")
    @Log(title = "模型信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysModel sysModel)
    {
        return toAjax(sysModelService.updateSysModel(sysModel));
    }

    /**
     * 删除模型信息
     */
    @PreAuthorize("@ss.hasPermi('system:model:remove')")
    @Log(title = "模型信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{modelIds}")
    public AjaxResult remove(@PathVariable Long[] modelIds)
    {
        return toAjax(sysModelService.deleteSysModelByModelIds(modelIds));
    }
}

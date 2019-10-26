package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.SysSetting;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.SysSettingService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.SysSettingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.SysSettingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import com.liulangzheli.ecwitkeyplus.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.common.param.IdParam;

/**
 * <p>
 * 系统设置 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/sysSetting")
@Api("系统设置 API")
public class SysSettingController extends BaseController {

    @Autowired
    private SysSettingService sysSettingService;

    /**
     * 添加系统设置
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加SysSetting对象", notes = "添加系统设置", response = ApiResult.class)
    public ApiResult<Boolean> addSysSetting(@Valid @RequestBody SysSetting sysSetting) throws Exception {
        boolean flag = sysSettingService.save(sysSetting);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统设置
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改SysSetting对象", notes = "修改系统设置", response = ApiResult.class)
    public ApiResult<Boolean> updateSysSetting(@Valid @RequestBody SysSetting sysSetting) throws Exception {
        boolean flag = sysSettingService.updateById(sysSetting);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统设置
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除SysSetting对象", notes = "删除系统设置", response = ApiResult.class)
    public ApiResult<Boolean> deleteSysSetting(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = sysSettingService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取系统设置
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取SysSetting对象详情", notes = "查看系统设置", response = SysSettingQueryVo.class)
    public ApiResult<SysSettingQueryVo> getSysSetting(@Valid @RequestBody IdParam idParam) throws Exception {
        SysSettingQueryVo sysSettingQueryVo = sysSettingService.getSysSettingById(idParam.getId());
        return ApiResult.ok(sysSettingQueryVo);
    }

    /**
     * 系统设置分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取SysSetting分页列表", notes = "系统设置分页列表", response = SysSettingQueryVo.class)
    public ApiResult<Paging<SysSettingQueryVo>> getSysSettingPageList(@Valid @RequestBody SysSettingQueryParam sysSettingQueryParam) throws Exception {
        Paging<SysSettingQueryVo> paging = sysSettingService.getSysSettingPageList(sysSettingQueryParam);
        return ApiResult.ok(paging);
    }

}


package com.liulangzheli.ecwitkeyplus.system.controller;

import com.liulangzheli.ecwitkeyplus.core.properties.EcWitkeyPlusProperties;
import com.liulangzheli.ecwitkeyplus.system.entity.SysUser;
import com.liulangzheli.ecwitkeyplus.system.param.ResetPasswordParam;
import com.liulangzheli.ecwitkeyplus.system.param.UpdatePasswordParam;
import com.liulangzheli.ecwitkeyplus.system.service.SysUserService;
import com.liulangzheli.ecwitkeyplus.system.param.SysUserQueryParam;
import com.liulangzheli.ecwitkeyplus.system.vo.SysUserQueryVo;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import com.liulangzheli.ecwitkeyplus.common.controller.BaseController;
import com.liulangzheli.ecwitkeyplus.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.common.param.IdParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * SystemUser 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Api("系统用户 API")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private EcWitkeyPlusProperties ecWitkeyPlusProperties;

    /**
     * 添加系统用户
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    @ApiOperation(value = "添加SysUser对象", notes = "添加系统用户", response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.saveSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 个人注册
     */
    @PostMapping("/register/personal")
    //@RequiresPermissions("sys:register:personal")
    @ApiOperation(value = "个人注册", notes = "注册个人用户", response = ApiResult.class)
    public ApiResult<Boolean> addSysUserForPersonal(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.saveSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 公司注册
     */
    @PostMapping("/register/company")
    //@RequiresPermissions("sys:register:company")
    @ApiOperation(value = "公司注册", notes = "注册公司用户", response = ApiResult.class)
    public ApiResult<Boolean> addSysUserForCompany(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.saveSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    @ApiOperation(value = "修改SysUser对象", notes = "修改系统用户", response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.updateSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户
     */
    @PostMapping("/update/personal")
    //@RequiresPermissions("sys:user:update:personal")
    @ApiOperation(value = "个人会员信息更新", notes = "个人会员信息更新", response = ApiResult.class)
    public ApiResult<Boolean> updateSysUserForPersonal(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.updateSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户
     */
    @PostMapping("/update/company")
    //@RequiresPermissions("sys:user:update:company")
    @ApiOperation(value = "企业会员信息更新", notes = "企业会员信息更新", response = ApiResult.class)
    public ApiResult<Boolean> updateSysUserForCompany(@Valid @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.updateSysUser(sysUser);
        return ApiResult.result(flag);
    }


    /**
     * 删除系统用户
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:user:delete")
    @ApiOperation(value = "删除SysUser对象", notes = "删除系统用户", response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = sysUserService.deleteSysUser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统用户
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:user:info")
    @ApiOperation(value = "获取SysUser对象详情", notes = "查看系统用户", response = SysUserQueryVo.class)
    public ApiResult<SysUserQueryVo> getSysUser(@PathVariable("id") Long id) throws Exception {
        SysUserQueryVo sysUserQueryVo = sysUserService.getSysUserById(id);
        return ApiResult.ok(sysUserQueryVo);
    }

    /**
     * 系统用户分页列表
     */
    @PostMapping("/getPageList")
    //@RequiresPermissions("sys:user:page")
    @ApiOperation(value = "获取SysUser分页列表", notes = "系统用户分页列表", response = SysUserQueryVo.class)
    public ApiResult<Paging<SysUserQueryVo>> getSysUserPageList(@Valid @RequestBody SysUserQueryParam sysUserQueryParam) throws Exception {
        Paging<SysUserQueryVo> paging = sysUserService.getSysUserPageList(sysUserQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    @RequiresPermissions("sys:user:update:password")
    @ApiOperation(value = "修改密码", notes = "修改密码", response = ApiResult.class)
    public ApiResult<Boolean> updatePassword(@Valid @RequestBody UpdatePasswordParam updatePasswordParam) throws Exception {
        boolean flag = sysUserService.updatePassword(updatePasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * 重置密码
     */
    @PostMapping("/resetPassword")
    @RequiresPermissions("sys:user:update:resetPassword")
    @ApiOperation(value = "修改密码", notes = "修改密码", response = ApiResult.class)
    public ApiResult<Boolean> resetPassword(@Valid @RequestBody ResetPasswordParam resetPasswordParam) throws Exception {
        boolean flag = sysUserService.resetPassword(resetPasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * 修改头像
     */
    @PostMapping("/uploadHead/{id}")
    @RequiresPermissions("sys:user:update:head")
    @ApiOperation(value = "修改头像",notes = "修改头像",response = ApiResult.class)
    public ApiResult<Boolean> uploadHead(@PathVariable("id") Long id,
                                         @RequestParam("head") MultipartFile multipartFile) throws Exception{
        log.info("multipartFile = " + multipartFile);
        log.info("ContentType = " + multipartFile.getContentType());
        log.info("OriginalFilename = " + multipartFile.getOriginalFilename());
        log.info("Name = " + multipartFile.getName());
        log.info("Size = " + multipartFile.getSize());

        // 上传文件，返回保存的文件名称
        String uploadPath = ecWitkeyPlusProperties.getUploadPath();
        String saveFileName = UploadUtil.upload(uploadPath, multipartFile);
        // 上传成功之后，返回访问路径，请根据实际情况设置
        String headPath = ecWitkeyPlusProperties.getResourceAccessUrl() + saveFileName;
        log.info("headPath:{}",headPath);

        boolean flag = sysUserService.updateSysUserHead(id,headPath);
        if (flag){
            return ApiResult.ok(headPath);
        }

        // 删除图片文件
        UploadUtil.deleteQuietly(uploadPath,saveFileName);
        return ApiResult.fail();
    }
}


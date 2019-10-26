package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.UnderCase;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.UnderCaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.UnderCaseQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.UnderCaseQueryVo;
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
 * 线下案例 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/underCase")
@Api("线下案例 API")
public class UnderCaseController extends BaseController {

    @Autowired
    private UnderCaseService underCaseService;

    /**
     * 添加线下案例
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加UnderCase对象", notes = "添加线下案例", response = ApiResult.class)
    public ApiResult<Boolean> addUnderCase(@Valid @RequestBody UnderCase underCase) throws Exception {
        boolean flag = underCaseService.save(underCase);
        return ApiResult.result(flag);
    }

    /**
     * 修改线下案例
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改UnderCase对象", notes = "修改线下案例", response = ApiResult.class)
    public ApiResult<Boolean> updateUnderCase(@Valid @RequestBody UnderCase underCase) throws Exception {
        boolean flag = underCaseService.updateById(underCase);
        return ApiResult.result(flag);
    }

    /**
     * 删除线下案例
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除UnderCase对象", notes = "删除线下案例", response = ApiResult.class)
    public ApiResult<Boolean> deleteUnderCase(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = underCaseService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取线下案例
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取UnderCase对象详情", notes = "查看线下案例", response = UnderCaseQueryVo.class)
    public ApiResult<UnderCaseQueryVo> getUnderCase(@Valid @RequestBody IdParam idParam) throws Exception {
        UnderCaseQueryVo underCaseQueryVo = underCaseService.getUnderCaseById(idParam.getId());
        return ApiResult.ok(underCaseQueryVo);
    }

    /**
     * 线下案例分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取UnderCase分页列表", notes = "线下案例分页列表", response = UnderCaseQueryVo.class)
    public ApiResult<Paging<UnderCaseQueryVo>> getUnderCasePageList(@Valid @RequestBody UnderCaseQueryParam underCaseQueryParam) throws Exception {
        Paging<UnderCaseQueryVo> paging = underCaseService.getUnderCasePageList(underCaseQueryParam);
        return ApiResult.ok(paging);
    }

}


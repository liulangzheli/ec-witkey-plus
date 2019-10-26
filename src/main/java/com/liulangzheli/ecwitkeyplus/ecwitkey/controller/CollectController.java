package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Collect;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.CollectService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CollectQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CollectQueryVo;
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
 * 收藏的服务商 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/collect")
@Api("收藏的服务商 API")
public class CollectController extends BaseController {

    @Autowired
    private CollectService collectService;

    /**
     * 添加收藏的服务商
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Collect对象", notes = "添加收藏的服务商", response = ApiResult.class)
    public ApiResult<Boolean> addCollect(@Valid @RequestBody Collect collect) throws Exception {
        boolean flag = collectService.save(collect);
        return ApiResult.result(flag);
    }

    /**
     * 修改收藏的服务商
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Collect对象", notes = "修改收藏的服务商", response = ApiResult.class)
    public ApiResult<Boolean> updateCollect(@Valid @RequestBody Collect collect) throws Exception {
        boolean flag = collectService.updateById(collect);
        return ApiResult.result(flag);
    }

    /**
     * 删除收藏的服务商
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除Collect对象", notes = "删除收藏的服务商", response = ApiResult.class)
    public ApiResult<Boolean> deleteCollect(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = collectService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取收藏的服务商
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取Collect对象详情", notes = "查看收藏的服务商", response = CollectQueryVo.class)
    public ApiResult<CollectQueryVo> getCollect(@Valid @RequestBody IdParam idParam) throws Exception {
        CollectQueryVo collectQueryVo = collectService.getCollectById(idParam.getId());
        return ApiResult.ok(collectQueryVo);
    }

    /**
     * 收藏的服务商分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Collect分页列表", notes = "收藏的服务商分页列表", response = CollectQueryVo.class)
    public ApiResult<Paging<CollectQueryVo>> getCollectPageList(@Valid @RequestBody CollectQueryParam collectQueryParam) throws Exception {
        Paging<CollectQueryVo> paging = collectService.getCollectPageList(collectQueryParam);
        return ApiResult.ok(paging);
    }

}


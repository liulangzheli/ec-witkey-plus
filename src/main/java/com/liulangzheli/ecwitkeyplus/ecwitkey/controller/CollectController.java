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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


        import javax.validation.Valid;
    
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.common.param.IdParam;

/**
 * <pre>
 * 收藏的服务商 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
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
        boolean flag = collectService.saveCollect(collect);
        return ApiResult.result(flag);
    }

    /**
     * 修改收藏的服务商
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Collect对象", notes = "修改收藏的服务商", response = ApiResult.class)
    public ApiResult<Boolean> updateCollect(@Valid @RequestBody Collect collect) throws Exception {
        boolean flag = collectService.updateCollect(collect);
        return ApiResult.result(flag);
    }

    /**
     * 删除收藏的服务商
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Collect对象", notes = "删除收藏的服务商", response = ApiResult.class)
    public ApiResult<Boolean> deleteCollect(@PathVariable("id") Long id) throws Exception {
        boolean flag = collectService.deleteCollect(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取收藏的服务商
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Collect对象详情", notes = "查看收藏的服务商", response = CollectQueryVo.class)
    public ApiResult<CollectQueryVo> getCollect(@PathVariable("id") Long id) throws Exception {
        CollectQueryVo collectQueryVo = collectService.getCollectById(id);
        return ApiResult.ok(collectQueryVo);
    }

    /**
     * 获取收藏的服务商
     */
    @GetMapping("/infoByUserId/{userId}")
    @ApiOperation(value = "获取Collect对象详情", notes = "查看收藏的服务商", response = CollectQueryVo.class)
    public ApiResult<CollectQueryVo> getCollectByUserId(@PathVariable("userId") Long userId) throws Exception {
        CollectQueryVo collectQueryVo = collectService.getCollectByUserId(userId);
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


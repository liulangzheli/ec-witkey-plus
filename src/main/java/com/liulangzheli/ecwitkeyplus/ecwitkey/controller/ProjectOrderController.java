package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectOrderService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
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
 * 项目订单 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@RestController
@RequestMapping("/projectOrder")
@Api("项目订单 API")
public class ProjectOrderController extends BaseController {

    @Autowired
    private ProjectOrderService projectOrderService;

    /**
     * 添加项目订单
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ProjectOrder对象", notes = "添加项目订单", response = ApiResult.class)
    public ApiResult<Boolean> addProjectOrder(@Valid @RequestBody ProjectOrder projectOrder) throws Exception {
        boolean flag = projectOrderService.saveProjectOrder(projectOrder);
        return ApiResult.result(flag);
    }

    /**
     * 修改项目订单
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ProjectOrder对象", notes = "修改项目订单", response = ApiResult.class)
    public ApiResult<Boolean> updateProjectOrder(@Valid @RequestBody ProjectOrder projectOrder) throws Exception {
        boolean flag = projectOrderService.updateProjectOrder(projectOrder);
        return ApiResult.result(flag);
    }

    /**
     * 删除项目订单
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除ProjectOrder对象", notes = "删除项目订单", response = ApiResult.class)
    public ApiResult<Boolean> deleteProjectOrder(@PathVariable("id") Long id) throws Exception {
        boolean flag = projectOrderService.deleteProjectOrder(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取项目订单
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取ProjectOrder对象详情", notes = "查看项目订单", response = ProjectOrderQueryVo.class)
    public ApiResult<ProjectOrderQueryVo> getProjectOrder(@PathVariable("id") Long id) throws Exception {
        ProjectOrderQueryVo projectOrderQueryVo = projectOrderService.getProjectOrderById(id);
        return ApiResult.ok(projectOrderQueryVo);
    }

    /**
     * 项目订单分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取ProjectOrder分页列表", notes = "项目订单分页列表", response = ProjectOrderQueryVo.class)
    public ApiResult<Paging<ProjectOrderQueryVo>> getProjectOrderPageList(@Valid @RequestBody ProjectOrderQueryParam projectOrderQueryParam) throws Exception {
        Paging<ProjectOrderQueryVo> paging = projectOrderService.getProjectOrderPageList(projectOrderQueryParam);
        return ApiResult.ok(paging);
    }

}


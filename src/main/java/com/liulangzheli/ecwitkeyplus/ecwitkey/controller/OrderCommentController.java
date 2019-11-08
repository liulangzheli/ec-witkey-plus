package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderComment;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderCommentService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCommentQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCommentQueryVo;
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
 * 订单评价 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
        @RestController
    @RequestMapping("/orderComment")
@Api("订单评价 API")
        public class OrderCommentController extends BaseController {
    
@Autowired
private OrderCommentService orderCommentService;

        /**
     * 添加订单评价
     */
    @PostMapping("/add")
            @ApiOperation(value = "添加OrderComment对象", notes = "添加订单评价", response = ApiResult.class)
    public ApiResult<Boolean> addOrderComment(@Valid @RequestBody OrderComment orderComment) throws Exception {
                        boolean flag = orderCommentService.saveOrderComment(orderComment);
                    return ApiResult.result(flag);
            }

    /**
     * 修改订单评价
     */
    @PostMapping("/update")
            @ApiOperation(value = "修改OrderComment对象", notes = "修改订单评价", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderComment(@Valid @RequestBody OrderComment orderComment) throws Exception {
                        boolean flag = orderCommentService.updateOrderComment(orderComment);
                    return ApiResult.result(flag);
            }

    /**
     * 删除订单评价
     */
    @PostMapping("/delete/{id}")
            @ApiOperation(value = "删除OrderComment对象", notes = "删除订单评价", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderComment(@PathVariable("id") Long id) throws Exception {
                        boolean flag = orderCommentService.deleteOrderComment(id);
                    return ApiResult.result(flag);
            }

    /**
     * 获取订单评价
     */
    @GetMapping("/info/{id}")
            @ApiOperation(value = "获取OrderComment对象详情", notes = "查看订单评价", response = OrderCommentQueryVo.class)
    public ApiResult<OrderCommentQueryVo> getOrderComment(@PathVariable("id") Long id) throws Exception {
        OrderCommentQueryVo orderCommentQueryVo = orderCommentService.getOrderCommentById(id);
            return ApiResult.ok(orderCommentQueryVo);
            }

    /**
     * 订单评价分页列表
     */
    @PostMapping("/getPageList")
            @ApiOperation(value = "获取OrderComment分页列表", notes = "订单评价分页列表", response = OrderCommentQueryVo.class)
    public ApiResult<Paging<OrderCommentQueryVo>> getOrderCommentPageList(@Valid @RequestBody OrderCommentQueryParam orderCommentQueryParam) throws Exception {
            Paging<OrderCommentQueryVo> paging = orderCommentService.getOrderCommentPageList(orderCommentQueryParam);
            return ApiResult.ok(paging);
            }
    
        }


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
 * 订单评价 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
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
        boolean flag = orderCommentService.save(orderComment);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单评价
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OrderComment对象", notes = "修改订单评价", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderComment(@Valid @RequestBody OrderComment orderComment) throws Exception {
        boolean flag = orderCommentService.updateById(orderComment);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单评价
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除OrderComment对象", notes = "删除订单评价", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderComment(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = orderCommentService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取订单评价
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取OrderComment对象详情", notes = "查看订单评价", response = OrderCommentQueryVo.class)
    public ApiResult<OrderCommentQueryVo> getOrderComment(@Valid @RequestBody IdParam idParam) throws Exception {
        OrderCommentQueryVo orderCommentQueryVo = orderCommentService.getOrderCommentById(idParam.getId());
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


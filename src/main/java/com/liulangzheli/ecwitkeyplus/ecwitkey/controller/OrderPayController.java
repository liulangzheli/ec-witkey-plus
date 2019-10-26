package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderPay;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderPayService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderPayQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderPayQueryVo;
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
 * 订单付款信息 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/orderPay")
@Api("订单付款信息 API")
public class OrderPayController extends BaseController {

    @Autowired
    private OrderPayService orderPayService;

    /**
     * 添加订单付款信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OrderPay对象", notes = "添加订单付款信息", response = ApiResult.class)
    public ApiResult<Boolean> addOrderPay(@Valid @RequestBody OrderPay orderPay) throws Exception {
        boolean flag = orderPayService.save(orderPay);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单付款信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OrderPay对象", notes = "修改订单付款信息", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderPay(@Valid @RequestBody OrderPay orderPay) throws Exception {
        boolean flag = orderPayService.updateById(orderPay);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单付款信息
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除OrderPay对象", notes = "删除订单付款信息", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderPay(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = orderPayService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取订单付款信息
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取OrderPay对象详情", notes = "查看订单付款信息", response = OrderPayQueryVo.class)
    public ApiResult<OrderPayQueryVo> getOrderPay(@Valid @RequestBody IdParam idParam) throws Exception {
        OrderPayQueryVo orderPayQueryVo = orderPayService.getOrderPayById(idParam.getId());
        return ApiResult.ok(orderPayQueryVo);
    }

    /**
     * 订单付款信息分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取OrderPay分页列表", notes = "订单付款信息分页列表", response = OrderPayQueryVo.class)
    public ApiResult<Paging<OrderPayQueryVo>> getOrderPayPageList(@Valid @RequestBody OrderPayQueryParam orderPayQueryParam) throws Exception {
        Paging<OrderPayQueryVo> paging = orderPayService.getOrderPayPageList(orderPayQueryParam);
        return ApiResult.ok(paging);
    }

}


package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderBiddingService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingQueryVo;
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
 * 订单竞标信息 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/orderBidding")
@Api("订单竞标信息 API")
public class OrderBiddingController extends BaseController {

    @Autowired
    private OrderBiddingService orderBiddingService;

    /**
     * 添加订单竞标信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OrderBidding对象", notes = "添加订单竞标信息", response = ApiResult.class)
    public ApiResult<Boolean> addOrderBidding(@Valid @RequestBody OrderBidding orderBidding) throws Exception {
        boolean flag = orderBiddingService.save(orderBidding);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单竞标信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OrderBidding对象", notes = "修改订单竞标信息", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderBidding(@Valid @RequestBody OrderBidding orderBidding) throws Exception {
        boolean flag = orderBiddingService.updateById(orderBidding);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单竞标信息
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除OrderBidding对象", notes = "删除订单竞标信息", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderBidding(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = orderBiddingService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取订单竞标信息
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取OrderBidding对象详情", notes = "查看订单竞标信息", response = OrderBiddingQueryVo.class)
    public ApiResult<OrderBiddingQueryVo> getOrderBidding(@Valid @RequestBody IdParam idParam) throws Exception {
        OrderBiddingQueryVo orderBiddingQueryVo = orderBiddingService.getOrderBiddingById(idParam.getId());
        return ApiResult.ok(orderBiddingQueryVo);
    }

    /**
     * 订单竞标信息分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取OrderBidding分页列表", notes = "订单竞标信息分页列表", response = OrderBiddingQueryVo.class)
    public ApiResult<Paging<OrderBiddingQueryVo>> getOrderBiddingPageList(@Valid @RequestBody OrderBiddingQueryParam orderBiddingQueryParam) throws Exception {
        Paging<OrderBiddingQueryVo> paging = orderBiddingService.getOrderBiddingPageList(orderBiddingQueryParam);
        return ApiResult.ok(paging);
    }

}


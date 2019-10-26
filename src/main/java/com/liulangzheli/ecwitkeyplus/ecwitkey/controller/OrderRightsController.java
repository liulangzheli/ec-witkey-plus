package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderRights;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderRightsService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderRightsQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderRightsQueryVo;
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
 * 订单维权 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/orderRights")
@Api("订单维权 API")
public class OrderRightsController extends BaseController {

    @Autowired
    private OrderRightsService orderRightsService;

    /**
     * 添加订单维权
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OrderRights对象", notes = "添加订单维权", response = ApiResult.class)
    public ApiResult<Boolean> addOrderRights(@Valid @RequestBody OrderRights orderRights) throws Exception {
        boolean flag = orderRightsService.save(orderRights);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单维权
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OrderRights对象", notes = "修改订单维权", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderRights(@Valid @RequestBody OrderRights orderRights) throws Exception {
        boolean flag = orderRightsService.updateById(orderRights);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单维权
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除OrderRights对象", notes = "删除订单维权", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderRights(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = orderRightsService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取订单维权
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取OrderRights对象详情", notes = "查看订单维权", response = OrderRightsQueryVo.class)
    public ApiResult<OrderRightsQueryVo> getOrderRights(@Valid @RequestBody IdParam idParam) throws Exception {
        OrderRightsQueryVo orderRightsQueryVo = orderRightsService.getOrderRightsById(idParam.getId());
        return ApiResult.ok(orderRightsQueryVo);
    }

    /**
     * 订单维权分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取OrderRights分页列表", notes = "订单维权分页列表", response = OrderRightsQueryVo.class)
    public ApiResult<Paging<OrderRightsQueryVo>> getOrderRightsPageList(@Valid @RequestBody OrderRightsQueryParam orderRightsQueryParam) throws Exception {
        Paging<OrderRightsQueryVo> paging = orderRightsService.getOrderRightsPageList(orderRightsQueryParam);
        return ApiResult.ok(paging);
    }

}


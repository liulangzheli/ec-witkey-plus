package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderCheck;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderCheckService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCheckQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCheckQueryVo;
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
 * 订单验收信息 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/orderCheck")
@Api("订单验收信息 API")
public class OrderCheckController extends BaseController {

    @Autowired
    private OrderCheckService orderCheckService;

    /**
     * 添加订单验收信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OrderCheck对象", notes = "添加订单验收信息", response = ApiResult.class)
    public ApiResult<Boolean> addOrderCheck(@Valid @RequestBody OrderCheck orderCheck) throws Exception {
        boolean flag = orderCheckService.save(orderCheck);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单验收信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OrderCheck对象", notes = "修改订单验收信息", response = ApiResult.class)
    public ApiResult<Boolean> updateOrderCheck(@Valid @RequestBody OrderCheck orderCheck) throws Exception {
        boolean flag = orderCheckService.updateById(orderCheck);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单验收信息
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除OrderCheck对象", notes = "删除订单验收信息", response = ApiResult.class)
    public ApiResult<Boolean> deleteOrderCheck(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = orderCheckService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取订单验收信息
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取OrderCheck对象详情", notes = "查看订单验收信息", response = OrderCheckQueryVo.class)
    public ApiResult<OrderCheckQueryVo> getOrderCheck(@Valid @RequestBody IdParam idParam) throws Exception {
        OrderCheckQueryVo orderCheckQueryVo = orderCheckService.getOrderCheckById(idParam.getId());
        return ApiResult.ok(orderCheckQueryVo);
    }

    /**
     * 订单验收信息分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取OrderCheck分页列表", notes = "订单验收信息分页列表", response = OrderCheckQueryVo.class)
    public ApiResult<Paging<OrderCheckQueryVo>> getOrderCheckPageList(@Valid @RequestBody OrderCheckQueryParam orderCheckQueryParam) throws Exception {
        Paging<OrderCheckQueryVo> paging = orderCheckService.getOrderCheckPageList(orderCheckQueryParam);
        return ApiResult.ok(paging);
    }

}


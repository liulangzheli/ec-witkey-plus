package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderPay;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderPayQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderPayQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单付款信息 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderPayService extends BaseService<OrderPay> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderPayQueryVo getOrderPayById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderPayQueryParam
     * @return
     */
    Paging<OrderPayQueryVo> getOrderPayPageList(OrderPayQueryParam orderPayQueryParam) throws Exception;

}

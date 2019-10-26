package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单竞标信息 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderBiddingService extends BaseService<OrderBidding> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderBiddingQueryVo getOrderBiddingById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderBiddingQueryParam
     * @return
     */
    Paging<OrderBiddingQueryVo> getOrderBiddingPageList(OrderBiddingQueryParam orderBiddingQueryParam) throws Exception;

}

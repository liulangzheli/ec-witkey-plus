package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderRights;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderRightsQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderRightsQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单维权 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderRightsService extends BaseService<OrderRights> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderRightsQueryVo getOrderRightsById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderRightsQueryParam
     * @return
     */
    Paging<OrderRightsQueryVo> getOrderRightsPageList(OrderRightsQueryParam orderRightsQueryParam) throws Exception;

}

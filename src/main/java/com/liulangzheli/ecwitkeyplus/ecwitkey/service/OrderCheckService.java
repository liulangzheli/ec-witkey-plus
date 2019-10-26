package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderCheck;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCheckQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCheckQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单验收信息 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderCheckService extends BaseService<OrderCheck> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderCheckQueryVo getOrderCheckById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderCheckQueryParam
     * @return
     */
    Paging<OrderCheckQueryVo> getOrderCheckPageList(OrderCheckQueryParam orderCheckQueryParam) throws Exception;

}

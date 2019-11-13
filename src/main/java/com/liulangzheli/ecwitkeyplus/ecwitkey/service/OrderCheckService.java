package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderCheck;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCheckQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCheckQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 订单验收信息 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface OrderCheckService extends BaseService<OrderCheck> {

    /**
     * 保存
     *
     * @param orderCheck
     * @return
     * @throws Exception
     */
    boolean saveOrderCheck(OrderCheck orderCheck) throws Exception;

    /**
     * 修改
     *
     * @param orderCheck
     * @return
     * @throws Exception
     */
    boolean updateOrderCheck(OrderCheck orderCheck) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteOrderCheck(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    OrderCheckQueryVo getOrderCheckById(Serializable id) throws Exception;


    /**
     * 根据orderId获取查询对象
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    OrderCheckQueryVo getOrderCheckByOrderId(Serializable orderId) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderCheckQueryParam
     * @return
     * @throws Exception
     */
    Paging<OrderCheckQueryVo> getOrderCheckPageList(OrderCheckQueryParam orderCheckQueryParam) throws Exception;

}

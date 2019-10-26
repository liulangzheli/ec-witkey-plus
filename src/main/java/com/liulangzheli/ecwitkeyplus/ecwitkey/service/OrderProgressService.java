package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderProgress;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderProgressQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderProgressQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单项目进度信息 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderProgressService extends BaseService<OrderProgress> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderProgressQueryVo getOrderProgressById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderProgressQueryParam
     * @return
     */
    Paging<OrderProgressQueryVo> getOrderProgressPageList(OrderProgressQueryParam orderProgressQueryParam) throws Exception;

}

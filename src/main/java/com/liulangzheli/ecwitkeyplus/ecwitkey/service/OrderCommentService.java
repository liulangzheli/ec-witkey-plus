package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderComment;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCommentQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCommentQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 订单评价 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface OrderCommentService extends BaseService<OrderComment> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderCommentQueryVo getOrderCommentById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param orderCommentQueryParam
     * @return
     */
    Paging<OrderCommentQueryVo> getOrderCommentPageList(OrderCommentQueryParam orderCommentQueryParam) throws Exception;

}

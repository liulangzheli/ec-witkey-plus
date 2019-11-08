package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderComment;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCommentQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCommentQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 订单评价 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface OrderCommentService extends BaseService<OrderComment> {
            
                /**
                 * 保存
                 *
                 * @param orderComment
                 * @return
                 * @throws Exception
                 */
                boolean saveOrderComment(OrderComment orderComment) throws Exception;

                /**
                 * 修改
                 *
                 * @param orderComment
                 * @return
                 * @throws Exception
                 */
                boolean updateOrderComment(OrderComment orderComment) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteOrderComment(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        OrderCommentQueryVo getOrderCommentById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param orderCommentQueryParam
             * @return
             * @throws Exception
             */
            Paging<OrderCommentQueryVo> getOrderCommentPageList(OrderCommentQueryParam orderCommentQueryParam) throws Exception;
    
        }

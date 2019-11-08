package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 订单竞标信息 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface OrderBiddingService extends BaseService<OrderBidding> {
            
                /**
                 * 保存
                 *
                 * @param orderBidding
                 * @return
                 * @throws Exception
                 */
                boolean saveOrderBidding(OrderBidding orderBidding) throws Exception;

                /**
                 * 修改
                 *
                 * @param orderBidding
                 * @return
                 * @throws Exception
                 */
                boolean updateOrderBidding(OrderBidding orderBidding) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteOrderBidding(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        OrderBiddingQueryVo getOrderBiddingById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param orderBiddingQueryParam
             * @return
             * @throws Exception
             */
            Paging<OrderBiddingQueryVo> getOrderBiddingPageList(OrderBiddingQueryParam orderBiddingQueryParam) throws Exception;
    
        }

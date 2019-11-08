package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderRights;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderRightsQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderRightsQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 订单维权 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface OrderRightsService extends BaseService<OrderRights> {
            
                /**
                 * 保存
                 *
                 * @param orderRights
                 * @return
                 * @throws Exception
                 */
                boolean saveOrderRights(OrderRights orderRights) throws Exception;

                /**
                 * 修改
                 *
                 * @param orderRights
                 * @return
                 * @throws Exception
                 */
                boolean updateOrderRights(OrderRights orderRights) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteOrderRights(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        OrderRightsQueryVo getOrderRightsById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param orderRightsQueryParam
             * @return
             * @throws Exception
             */
            Paging<OrderRightsQueryVo> getOrderRightsPageList(OrderRightsQueryParam orderRightsQueryParam) throws Exception;
    
        }

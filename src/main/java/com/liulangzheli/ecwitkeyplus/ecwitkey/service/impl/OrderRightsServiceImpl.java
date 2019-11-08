package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderRights;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderRightsMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderRightsService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderRightsQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderRightsQueryVo;
import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 订单维权 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class OrderRightsServiceImpl extends BaseServiceImpl<OrderRightsMapper, OrderRights> implements OrderRightsService {

        @Autowired
        private OrderRightsMapper orderRightsMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveOrderRights(OrderRights orderRights) throws Exception {
                return super.save(orderRights);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateOrderRights(OrderRights orderRights) throws Exception {
                return super.updateById(orderRights);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteOrderRights(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public OrderRightsQueryVo getOrderRightsById(Serializable id) throws Exception {
            return orderRightsMapper.getOrderRightsById(id);
            }

            @Override
            public Paging<OrderRightsQueryVo> getOrderRightsPageList(OrderRightsQueryParam orderRightsQueryParam) throws Exception {
            Page page = setPageParam(orderRightsQueryParam, OrderItem.desc("create_time"));
            IPage<OrderRightsQueryVo> iPage = orderRightsMapper.getOrderRightsPageList(page, orderRightsQueryParam);
            return new Paging(iPage);
            }
    
        }

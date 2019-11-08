package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderPay;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderPayMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderPayService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderPayQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderPayQueryVo;
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
 * 订单付款信息 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class OrderPayServiceImpl extends BaseServiceImpl<OrderPayMapper, OrderPay> implements OrderPayService {

        @Autowired
        private OrderPayMapper orderPayMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveOrderPay(OrderPay orderPay) throws Exception {
                return super.save(orderPay);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateOrderPay(OrderPay orderPay) throws Exception {
                return super.updateById(orderPay);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteOrderPay(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public OrderPayQueryVo getOrderPayById(Serializable id) throws Exception {
            return orderPayMapper.getOrderPayById(id);
            }

            @Override
            public Paging<OrderPayQueryVo> getOrderPayPageList(OrderPayQueryParam orderPayQueryParam) throws Exception {
            Page page = setPageParam(orderPayQueryParam, OrderItem.desc("create_time"));
            IPage<OrderPayQueryVo> iPage = orderPayMapper.getOrderPayPageList(page, orderPayQueryParam);
            return new Paging(iPage);
            }
    
        }

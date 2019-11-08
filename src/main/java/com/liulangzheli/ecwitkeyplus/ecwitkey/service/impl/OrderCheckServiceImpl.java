package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderCheck;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderCheckMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderCheckService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCheckQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCheckQueryVo;
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
 * 订单验收信息 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class OrderCheckServiceImpl extends BaseServiceImpl<OrderCheckMapper, OrderCheck> implements OrderCheckService {

        @Autowired
        private OrderCheckMapper orderCheckMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveOrderCheck(OrderCheck orderCheck) throws Exception {
                return super.save(orderCheck);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateOrderCheck(OrderCheck orderCheck) throws Exception {
                return super.updateById(orderCheck);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteOrderCheck(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public OrderCheckQueryVo getOrderCheckById(Serializable id) throws Exception {
            return orderCheckMapper.getOrderCheckById(id);
            }

            @Override
            public Paging<OrderCheckQueryVo> getOrderCheckPageList(OrderCheckQueryParam orderCheckQueryParam) throws Exception {
            Page page = setPageParam(orderCheckQueryParam, OrderItem.desc("create_time"));
            IPage<OrderCheckQueryVo> iPage = orderCheckMapper.getOrderCheckPageList(page, orderCheckQueryParam);
            return new Paging(iPage);
            }
    
        }

package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderProgress;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderProgressMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderProgressService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderProgressQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderProgressQueryVo;
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
 * 订单项目进度信息 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class OrderProgressServiceImpl extends BaseServiceImpl<OrderProgressMapper, OrderProgress> implements OrderProgressService {

        @Autowired
        private OrderProgressMapper orderProgressMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveOrderProgress(OrderProgress orderProgress) throws Exception {
                return super.save(orderProgress);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateOrderProgress(OrderProgress orderProgress) throws Exception {
                return super.updateById(orderProgress);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteOrderProgress(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public OrderProgressQueryVo getOrderProgressById(Serializable id) throws Exception {
            return orderProgressMapper.getOrderProgressById(id);
            }

            @Override
            public Paging<OrderProgressQueryVo> getOrderProgressPageList(OrderProgressQueryParam orderProgressQueryParam) throws Exception {
            Page page = setPageParam(orderProgressQueryParam, OrderItem.desc("create_time"));
            IPage<OrderProgressQueryVo> iPage = orderProgressMapper.getOrderProgressPageList(page, orderProgressQueryParam);
            return new Paging(iPage);
            }
    
        }

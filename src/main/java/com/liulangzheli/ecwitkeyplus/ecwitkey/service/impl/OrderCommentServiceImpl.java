package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderComment;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderCommentMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderCommentService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCommentQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCommentQueryVo;
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
 * 订单评价 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class OrderCommentServiceImpl extends BaseServiceImpl<OrderCommentMapper, OrderComment> implements OrderCommentService {

        @Autowired
        private OrderCommentMapper orderCommentMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveOrderComment(OrderComment orderComment) throws Exception {
                return super.save(orderComment);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateOrderComment(OrderComment orderComment) throws Exception {
                return super.updateById(orderComment);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteOrderComment(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public OrderCommentQueryVo getOrderCommentById(Serializable id) throws Exception {
            return orderCommentMapper.getOrderCommentById(id);
            }

            @Override
            public Paging<OrderCommentQueryVo> getOrderCommentPageList(OrderCommentQueryParam orderCommentQueryParam) throws Exception {
            Page page = setPageParam(orderCommentQueryParam, OrderItem.desc("create_time"));
            IPage<OrderCommentQueryVo> iPage = orderCommentMapper.getOrderCommentPageList(page, orderCommentQueryParam);
            return new Paging(iPage);
            }
    
        }

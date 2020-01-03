package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderBiddingMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderBiddingService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingInfoQueryVo;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingQueryVo;
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
import java.util.List;


/**
 * <pre>
 * 订单竞标信息 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
public class OrderBiddingServiceImpl extends BaseServiceImpl<OrderBiddingMapper, OrderBidding> implements OrderBiddingService {

    @Autowired
    private OrderBiddingMapper orderBiddingMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrderBidding(OrderBidding orderBidding) throws Exception {
        return super.save(orderBidding);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOrderBidding(OrderBidding orderBidding) throws Exception {
        return super.updateById(orderBidding);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOrderBidding(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public OrderBiddingQueryVo getOrderBiddingById(Serializable id) throws Exception {
        return orderBiddingMapper.getOrderBiddingById(id);
    }

    @Override
    public List<OrderBiddingInfoQueryVo> getOrderBiddingByOrderId(Serializable orderId) throws Exception {
        return orderBiddingMapper.getOrderBiddingByOrderId(orderId);
    }

    @Override
    public Paging<OrderBiddingQueryVo> getOrderBiddingPageList(OrderBiddingQueryParam orderBiddingQueryParam) throws Exception {
        Page page = setPageParam(orderBiddingQueryParam, OrderItem.desc("create_time"));
        IPage<OrderBiddingQueryVo> iPage = orderBiddingMapper.getOrderBiddingPageList(page, orderBiddingQueryParam);
        return new Paging(iPage);
    }

    @Override
    public Paging<OrderBiddingInfoQueryVo> getOrderBiddingListByUserIdAndOrderId(OrderBiddingQueryParam orderBiddingQueryParam) throws Exception {
        Page page = setPageParam(orderBiddingQueryParam, OrderItem.desc("create_time"));
        IPage<OrderBiddingInfoQueryVo> iPage = orderBiddingMapper.getOrderBiddingListByUserIdAndOrderId(page, orderBiddingQueryParam);
        return new Paging(iPage);
    }

}

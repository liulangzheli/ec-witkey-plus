package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.OrderBiddingMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.OrderBiddingService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
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


/**
 * <p>
 * 订单竞标信息 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderBiddingServiceImpl extends BaseServiceImpl<OrderBiddingMapper, OrderBidding> implements OrderBiddingService {

    @Autowired
    private OrderBiddingMapper orderBiddingMapper;

    @Override
    public OrderBiddingQueryVo getOrderBiddingById(Serializable id) throws Exception {
        return orderBiddingMapper.getOrderBiddingById(id);
    }

    @Override
    public Paging<OrderBiddingQueryVo> getOrderBiddingPageList(OrderBiddingQueryParam orderBiddingQueryParam) throws Exception {
        Page page = setPageParam(orderBiddingQueryParam, OrderItem.desc("create_time"));
        IPage<OrderBiddingQueryVo> iPage = orderBiddingMapper.getOrderBiddingPageList(page, orderBiddingQueryParam);
        return new Paging(iPage);
    }

}

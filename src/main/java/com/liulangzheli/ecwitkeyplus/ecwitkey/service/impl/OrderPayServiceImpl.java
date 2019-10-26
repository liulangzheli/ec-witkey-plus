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
 * <p>
 * 订单付款信息 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderPayServiceImpl extends BaseServiceImpl<OrderPayMapper, OrderPay> implements OrderPayService {

    @Autowired
    private OrderPayMapper orderPayMapper;

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

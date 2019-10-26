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
 * <p>
 * 订单验收信息 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderCheckServiceImpl extends BaseServiceImpl<OrderCheckMapper, OrderCheck> implements OrderCheckService {

    @Autowired
    private OrderCheckMapper orderCheckMapper;

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

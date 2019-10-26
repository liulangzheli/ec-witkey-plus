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
 * <p>
 * 订单项目进度信息 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderProgressServiceImpl extends BaseServiceImpl<OrderProgressMapper, OrderProgress> implements OrderProgressService {

    @Autowired
    private OrderProgressMapper orderProgressMapper;

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

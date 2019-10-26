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
 * <p>
 * 订单维权 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderRightsServiceImpl extends BaseServiceImpl<OrderRightsMapper, OrderRights> implements OrderRightsService {

    @Autowired
    private OrderRightsMapper orderRightsMapper;

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

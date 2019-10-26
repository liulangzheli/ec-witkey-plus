package com.liulangzheli.ecwitkeyplus.system.service.impl;

import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.Ip;
import com.liulangzheli.ecwitkeyplus.system.mapper.IpMapper;
import com.liulangzheli.ecwitkeyplus.system.param.IpQueryParam;
import com.liulangzheli.ecwitkeyplus.system.service.IpService;
import com.liulangzheli.ecwitkeyplus.system.vo.IpQueryVo;
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
 * IP地址 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IpServiceImpl extends BaseServiceImpl<IpMapper, Ip> implements IpService {

    @Autowired
    private IpMapper ipMapper;

    @Override
    public IpQueryVo getIpById(Serializable id) throws Exception {
        return ipMapper.getIpById(id);
    }

    @Override
    public Paging<IpQueryVo> getIpPageList(IpQueryParam ipQueryParam) throws Exception {
        Page page = setPageParam(ipQueryParam, OrderItem.desc("create_time"));
        IPage<IpQueryVo> iPage = ipMapper.getIpPageList(page, ipQueryParam);
        return new Paging(iPage);
    }

}

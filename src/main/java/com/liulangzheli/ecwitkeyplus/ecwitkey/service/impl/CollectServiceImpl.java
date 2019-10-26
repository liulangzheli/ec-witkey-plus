package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Collect;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.CollectMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.CollectService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CollectQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CollectQueryVo;
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
 * 收藏的服务商 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class CollectServiceImpl extends BaseServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public CollectQueryVo getCollectById(Serializable id) throws Exception {
        return collectMapper.getCollectById(id);
    }

    @Override
    public Paging<CollectQueryVo> getCollectPageList(CollectQueryParam collectQueryParam) throws Exception {
        Page page = setPageParam(collectQueryParam, OrderItem.desc("create_time"));
        IPage<CollectQueryVo> iPage = collectMapper.getCollectPageList(page, collectQueryParam);
        return new Paging(iPage);
    }

}

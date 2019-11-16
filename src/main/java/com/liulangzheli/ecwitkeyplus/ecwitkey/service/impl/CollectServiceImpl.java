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
 * <pre>
 * 收藏的服务商 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
public class CollectServiceImpl extends BaseServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCollect(Collect collect) throws Exception {
        return super.save(collect);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCollect(Collect collect) throws Exception {
        return super.updateById(collect);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCollect(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public CollectQueryVo getCollectById(Serializable id) throws Exception {
        return collectMapper.getCollectById(id);
    }

    @Override
    public CollectQueryVo getCollectByUserId(Serializable userId) throws Exception {
        return collectMapper.getCollectByUserId(userId);
    }

    @Override
    public Paging<CollectQueryVo> getCollectPageList(CollectQueryParam collectQueryParam) throws Exception {
        Page page = setPageParam(collectQueryParam, OrderItem.desc("create_time"));
        IPage<CollectQueryVo> iPage = collectMapper.getCollectPageList(page, collectQueryParam);
        return new Paging(iPage);
    }

}

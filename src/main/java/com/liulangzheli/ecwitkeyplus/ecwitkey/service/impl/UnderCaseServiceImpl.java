package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.UnderCase;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.UnderCaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.UnderCaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.UnderCaseQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.UnderCaseQueryVo;
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
 * 线下案例 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
public class UnderCaseServiceImpl extends BaseServiceImpl<UnderCaseMapper, UnderCase> implements UnderCaseService {

    @Autowired
    private UnderCaseMapper underCaseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUnderCase(UnderCase underCase) throws Exception {
        return super.save(underCase);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUnderCase(UnderCase underCase) throws Exception {
        return super.updateById(underCase);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUnderCase(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public UnderCaseQueryVo getUnderCaseById(Serializable id) throws Exception {
        return underCaseMapper.getUnderCaseById(id);
    }

    @Override
    public UnderCaseQueryVo getUnderCaseByUserId(Serializable userId) throws Exception {
        return underCaseMapper.getUnderCaseByUserId(userId);
    }

    @Override
    public Paging<UnderCaseQueryVo> getUnderCasePageList(UnderCaseQueryParam underCaseQueryParam) throws Exception {
        Page page = setPageParam(underCaseQueryParam, OrderItem.desc("create_time"));
        IPage<UnderCaseQueryVo> iPage = underCaseMapper.getUnderCasePageList(page, underCaseQueryParam);
        return new Paging(iPage);
    }

}

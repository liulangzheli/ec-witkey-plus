package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Article;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ArticleMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ArticleService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ArticleQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ArticleQueryVo;
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
 * 文章 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleQueryVo getArticleById(Serializable id) throws Exception {
        return articleMapper.getArticleById(id);
    }

    @Override
    public Paging<ArticleQueryVo> getArticlePageList(ArticleQueryParam articleQueryParam) throws Exception {
        Page page = setPageParam(articleQueryParam, OrderItem.desc("create_time"));
        IPage<ArticleQueryVo> iPage = articleMapper.getArticlePageList(page, articleQueryParam);
        return new Paging(iPage);
    }

}

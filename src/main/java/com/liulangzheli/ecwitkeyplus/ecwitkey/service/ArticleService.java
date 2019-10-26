package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Article;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ArticleQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ArticleQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface ArticleService extends BaseService<Article> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ArticleQueryVo getArticleById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param articleQueryParam
     * @return
     */
    Paging<ArticleQueryVo> getArticlePageList(ArticleQueryParam articleQueryParam) throws Exception;

}

package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Article;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ArticleQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ArticleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ArticleQueryVo getArticleById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param articleQueryParam
     * @return
     */
    IPage<ArticleQueryVo> getArticlePageList(@Param("page") Page page, @Param("param") ArticleQueryParam articleQueryParam);

}

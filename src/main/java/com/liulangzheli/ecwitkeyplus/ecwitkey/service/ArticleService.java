package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Article;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ArticleQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ArticleQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 文章 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface ArticleService extends BaseService<Article> {
            
                /**
                 * 保存
                 *
                 * @param article
                 * @return
                 * @throws Exception
                 */
                boolean saveArticle(Article article) throws Exception;

                /**
                 * 修改
                 *
                 * @param article
                 * @return
                 * @throws Exception
                 */
                boolean updateArticle(Article article) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteArticle(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        ArticleQueryVo getArticleById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param articleQueryParam
             * @return
             * @throws Exception
             */
            Paging<ArticleQueryVo> getArticlePageList(ArticleQueryParam articleQueryParam) throws Exception;
    
        }

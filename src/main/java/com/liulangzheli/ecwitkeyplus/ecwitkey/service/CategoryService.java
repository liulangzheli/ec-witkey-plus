package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Category;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CategoryQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CategoryQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 类别管理 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface CategoryService extends BaseService<Category> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CategoryQueryVo getCategoryById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param categoryQueryParam
     * @return
     */
    Paging<CategoryQueryVo> getCategoryPageList(CategoryQueryParam categoryQueryParam) throws Exception;

}

package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Category;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CategoryQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CategoryQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 类别管理 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CategoryQueryVo getCategoryById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param categoryQueryParam
     * @return
     */
    IPage<CategoryQueryVo> getCategoryPageList(@Param("page") Page page, @Param("param") CategoryQueryParam categoryQueryParam);

}

package com.liulangzheli.ecwitkeyplus.foobar.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.foobar.entity.FooBar;
import com.liulangzheli.ecwitkeyplus.foobar.param.FooBarQueryParam;
import com.liulangzheli.ecwitkeyplus.foobar.vo.FooBarQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * FooBar Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface FooBarMapper extends BaseMapper<FooBar> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        FooBarQueryVo getFooBarById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param fooBarQueryParam
             * @return
             */
            IPage<FooBarQueryVo> getFooBarPageList(@Param("page") Page page, @Param("param") FooBarQueryParam fooBarQueryParam);
    
        }

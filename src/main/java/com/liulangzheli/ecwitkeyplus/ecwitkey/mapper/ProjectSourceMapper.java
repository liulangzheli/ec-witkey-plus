package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectSource;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectSourceQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectSourceQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 项目资料 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface ProjectSourceMapper extends BaseMapper<ProjectSource> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        ProjectSourceQueryVo getProjectSourceById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param projectSourceQueryParam
             * @return
             */
            IPage<ProjectSourceQueryVo> getProjectSourcePageList(@Param("page") Page page, @Param("param") ProjectSourceQueryParam projectSourceQueryParam);
    
        }

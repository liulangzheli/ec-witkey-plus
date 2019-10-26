package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectExamine;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectExamineQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectExamineQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 项目审核 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface ProjectExamineMapper extends BaseMapper<ProjectExamine> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectExamineQueryVo getProjectExamineById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param projectExamineQueryParam
     * @return
     */
    IPage<ProjectExamineQueryVo> getProjectExaminePageList(@Param("page") Page page, @Param("param") ProjectExamineQueryParam projectExamineQueryParam);

}

package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 项目类型要求 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface ProjectRequirementMapper extends BaseMapper<ProjectRequirement> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectRequirementQueryVo getProjectRequirementById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param projectRequirementQueryParam
     * @return
     */
    IPage<ProjectRequirementQueryVo> getProjectRequirementPageList(@Param("page") Page page, @Param("param") ProjectRequirementQueryParam projectRequirementQueryParam);

}

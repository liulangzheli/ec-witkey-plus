package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 项目类型要求 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface ProjectRequirementService extends BaseService<ProjectRequirement> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectRequirementQueryVo getProjectRequirementById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param projectRequirementQueryParam
     * @return
     */
    Paging<ProjectRequirementQueryVo> getProjectRequirementPageList(ProjectRequirementQueryParam projectRequirementQueryParam) throws Exception;

}

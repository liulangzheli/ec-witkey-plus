package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectExamine;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectExamineQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectExamineQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 项目审核 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface ProjectExamineService extends BaseService<ProjectExamine> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectExamineQueryVo getProjectExamineById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param projectExamineQueryParam
     * @return
     */
    Paging<ProjectExamineQueryVo> getProjectExaminePageList(ProjectExamineQueryParam projectExamineQueryParam) throws Exception;

}

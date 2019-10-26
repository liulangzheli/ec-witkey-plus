package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectSource;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectSourceQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectSourceQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 项目资料 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface ProjectSourceService extends BaseService<ProjectSource> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectSourceQueryVo getProjectSourceById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param projectSourceQueryParam
     * @return
     */
    Paging<ProjectSourceQueryVo> getProjectSourcePageList(ProjectSourceQueryParam projectSourceQueryParam) throws Exception;

}

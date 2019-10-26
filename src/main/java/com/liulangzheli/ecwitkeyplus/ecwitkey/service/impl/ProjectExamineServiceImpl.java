package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectExamine;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectExamineMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectExamineService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectExamineQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectExamineQueryVo;
import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;


/**
 * <p>
 * 项目审核 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectExamineServiceImpl extends BaseServiceImpl<ProjectExamineMapper, ProjectExamine> implements ProjectExamineService {

    @Autowired
    private ProjectExamineMapper projectExamineMapper;

    @Override
    public ProjectExamineQueryVo getProjectExamineById(Serializable id) throws Exception {
        return projectExamineMapper.getProjectExamineById(id);
    }

    @Override
    public Paging<ProjectExamineQueryVo> getProjectExaminePageList(ProjectExamineQueryParam projectExamineQueryParam) throws Exception {
        Page page = setPageParam(projectExamineQueryParam, OrderItem.desc("create_time"));
        IPage<ProjectExamineQueryVo> iPage = projectExamineMapper.getProjectExaminePageList(page, projectExamineQueryParam);
        return new Paging(iPage);
    }

}

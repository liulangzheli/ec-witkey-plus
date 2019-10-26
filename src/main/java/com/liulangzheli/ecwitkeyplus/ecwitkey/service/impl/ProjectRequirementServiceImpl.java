package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectRequirementMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectRequirementService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
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
 * 项目类型要求 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectRequirementServiceImpl extends BaseServiceImpl<ProjectRequirementMapper, ProjectRequirement> implements ProjectRequirementService {

    @Autowired
    private ProjectRequirementMapper projectRequirementMapper;

    @Override
    public ProjectRequirementQueryVo getProjectRequirementById(Serializable id) throws Exception {
        return projectRequirementMapper.getProjectRequirementById(id);
    }

    @Override
    public Paging<ProjectRequirementQueryVo> getProjectRequirementPageList(ProjectRequirementQueryParam projectRequirementQueryParam) throws Exception {
        Page page = setPageParam(projectRequirementQueryParam, OrderItem.desc("create_time"));
        IPage<ProjectRequirementQueryVo> iPage = projectRequirementMapper.getProjectRequirementPageList(page, projectRequirementQueryParam);
        return new Paging(iPage);
    }

}

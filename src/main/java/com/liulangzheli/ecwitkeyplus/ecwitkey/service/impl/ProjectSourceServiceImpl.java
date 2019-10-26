package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectSource;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectSourceMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectSourceService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectSourceQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectSourceQueryVo;
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
 * 项目资料 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectSourceServiceImpl extends BaseServiceImpl<ProjectSourceMapper, ProjectSource> implements ProjectSourceService {

    @Autowired
    private ProjectSourceMapper projectSourceMapper;

    @Override
    public ProjectSourceQueryVo getProjectSourceById(Serializable id) throws Exception {
        return projectSourceMapper.getProjectSourceById(id);
    }

    @Override
    public Paging<ProjectSourceQueryVo> getProjectSourcePageList(ProjectSourceQueryParam projectSourceQueryParam) throws Exception {
        Page page = setPageParam(projectSourceQueryParam, OrderItem.desc("create_time"));
        IPage<ProjectSourceQueryVo> iPage = projectSourceMapper.getProjectSourcePageList(page, projectSourceQueryParam);
        return new Paging(iPage);
    }

}

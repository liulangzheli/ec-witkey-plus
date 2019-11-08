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
 * <pre>
 * 项目资料 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class ProjectSourceServiceImpl extends BaseServiceImpl<ProjectSourceMapper, ProjectSource> implements ProjectSourceService {

        @Autowired
        private ProjectSourceMapper projectSourceMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveProjectSource(ProjectSource projectSource) throws Exception {
                return super.save(projectSource);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateProjectSource(ProjectSource projectSource) throws Exception {
                return super.updateById(projectSource);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteProjectSource(Long id) throws Exception {
                return super.removeById(id);
                }
        
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

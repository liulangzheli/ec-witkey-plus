package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectRequirementMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectRequirementService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementCategoryQueryVo;
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
import java.util.List;


/**
 * <pre>
 * 项目类型要求 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class ProjectRequirementServiceImpl extends BaseServiceImpl<ProjectRequirementMapper, ProjectRequirement> implements ProjectRequirementService {

        @Autowired
        private ProjectRequirementMapper projectRequirementMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveProjectRequirement(ProjectRequirement projectRequirement) throws Exception {
                return super.save(projectRequirement);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateProjectRequirement(ProjectRequirement projectRequirement) throws Exception {
                return super.updateById(projectRequirement);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteProjectRequirement(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public ProjectRequirementQueryVo getProjectRequirementById(Serializable id) throws Exception {
            return projectRequirementMapper.getProjectRequirementById(id);
            }

            @Override
            public List<ProjectRequirementQueryVo> getProjectRequirementsByOrderId(Serializable orderId) throws Exception {
                List<ProjectRequirementQueryVo> list = projectRequirementMapper.getProjectRequirementsByOrderId(orderId);
                    return list;
            }

            @Override
            public Paging<ProjectRequirementQueryVo> getProjectRequirementPageList(ProjectRequirementQueryParam projectRequirementQueryParam) throws Exception {
            Page page = setPageParam(projectRequirementQueryParam, OrderItem.desc("create_time"));
            IPage<ProjectRequirementQueryVo> iPage = projectRequirementMapper.getProjectRequirementPageList(page, projectRequirementQueryParam);
            return new Paging(iPage);
            }

            @Override
            public Paging<ProjectRequirementCategoryQueryVo> getProjectRequirementPageListByOrderId(Serializable orderId) throws Exception {
                IPage<ProjectRequirementCategoryQueryVo> iPage = projectRequirementMapper.getProjectRequirementPageListByOrderId(orderId);
                return new Paging(iPage);
            }
    
        }

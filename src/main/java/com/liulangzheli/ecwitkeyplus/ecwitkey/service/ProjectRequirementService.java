package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 项目类型要求 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface ProjectRequirementService extends BaseService<ProjectRequirement> {
            
                /**
                 * 保存
                 *
                 * @param projectRequirement
                 * @return
                 * @throws Exception
                 */
                boolean saveProjectRequirement(ProjectRequirement projectRequirement) throws Exception;

                /**
                 * 修改
                 *
                 * @param projectRequirement
                 * @return
                 * @throws Exception
                 */
                boolean updateProjectRequirement(ProjectRequirement projectRequirement) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteProjectRequirement(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        ProjectRequirementQueryVo getProjectRequirementById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param projectRequirementQueryParam
             * @return
             * @throws Exception
             */
            Paging<ProjectRequirementQueryVo> getProjectRequirementPageList(ProjectRequirementQueryParam projectRequirementQueryParam) throws Exception;
    
        }

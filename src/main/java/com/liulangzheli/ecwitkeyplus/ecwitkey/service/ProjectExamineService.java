package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectExamine;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectExamineQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectExamineQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 项目审核 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface ProjectExamineService extends BaseService<ProjectExamine> {
            
                /**
                 * 保存
                 *
                 * @param projectExamine
                 * @return
                 * @throws Exception
                 */
                boolean saveProjectExamine(ProjectExamine projectExamine) throws Exception;

                /**
                 * 修改
                 *
                 * @param projectExamine
                 * @return
                 * @throws Exception
                 */
                boolean updateProjectExamine(ProjectExamine projectExamine) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteProjectExamine(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        ProjectExamineQueryVo getProjectExamineById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param projectExamineQueryParam
             * @return
             * @throws Exception
             */
            Paging<ProjectExamineQueryVo> getProjectExaminePageList(ProjectExamineQueryParam projectExamineQueryParam) throws Exception;
    
        }

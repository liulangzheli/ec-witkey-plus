package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectSource;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectSourceQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectSourceQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 项目资料 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface ProjectSourceService extends BaseService<ProjectSource> {
            
                /**
                 * 保存
                 *
                 * @param projectSource
                 * @return
                 * @throws Exception
                 */
                boolean saveProjectSource(ProjectSource projectSource) throws Exception;

                /**
                 * 修改
                 *
                 * @param projectSource
                 * @return
                 * @throws Exception
                 */
                boolean updateProjectSource(ProjectSource projectSource) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteProjectSource(Long id) throws Exception;
        
                /**
                 * 根据ID获取查询对象
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                ProjectSourceQueryVo getProjectSourceById(Serializable id) throws Exception;

                /**
                 * 根据ID获取查询对象
                 *
                 * @param orderId
                 * @return
                 * @throws Exception
                 */
                ProjectSourceQueryVo getProjectSourceByOrderId(Serializable orderId) throws Exception;

                /**
                 * 获取分页对象
                 *
                 * @param projectSourceQueryParam
                 * @return
                 * @throws Exception
                 */
                Paging<ProjectSourceQueryVo> getProjectSourcePageList(ProjectSourceQueryParam projectSourceQueryParam) throws Exception;
    
        }

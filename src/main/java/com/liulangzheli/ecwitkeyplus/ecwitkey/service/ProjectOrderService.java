package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderUserQueryVo;

import java.io.Serializable;

/**
 * <pre>
 * 项目订单 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface ProjectOrderService extends BaseService<ProjectOrder> {

    /**
     * 保存
     *
     * @param projectOrder
     * @return
     * @throws Exception
     */
    boolean saveProjectOrder(ProjectOrder projectOrder) throws Exception;

    /**
     * 修改
     *
     * @param projectOrder
     * @return
     * @throws Exception
     */
    boolean updateProjectOrder(ProjectOrder projectOrder) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteProjectOrder(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ProjectOrderQueryVo getProjectOrderById(Serializable id) throws Exception;

    /**
     * 根据USERID获取查询对象
     *
     * @param userId
     * @return
     * @throws Exception
     */
    ProjectOrderQueryVo getProjectOrderByUserId(Serializable userId) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ProjectOrderUserQueryVo getProjectOrderUserById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param projectOrderQueryParam
     * @return
     * @throws Exception
     */
    Paging<ProjectOrderQueryVo> getProjectOrderPageList(ProjectOrderQueryParam projectOrderQueryParam) throws Exception;

}

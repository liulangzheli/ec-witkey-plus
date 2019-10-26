package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 项目订单 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface ProjectOrderService extends BaseService<ProjectOrder> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectOrderQueryVo getProjectOrderById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param projectOrderQueryParam
     * @return
     */
    Paging<ProjectOrderQueryVo> getProjectOrderPageList(ProjectOrderQueryParam projectOrderQueryParam) throws Exception;

}

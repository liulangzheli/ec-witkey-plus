package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderUserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 项目订单 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface ProjectOrderMapper extends BaseMapper<ProjectOrder> {

    /**
     * 保存对象
     * @param projectOrder
     * @return
     */
    Long insertProjectOrder(ProjectOrder projectOrder);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectOrderQueryVo getProjectOrderById(Serializable id);

    /**
     * 根据USER_ID获取查询对象
     *
     * @param userId
     * @return
     */
    ProjectOrderQueryVo getProjectOrderByUserId(Serializable userId);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ProjectOrderUserQueryVo getProjectOrderUserById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param projectOrderQueryParam
     * @return
     */
    IPage<ProjectOrderQueryVo> getProjectOrderPageList(@Param("page") Page page, @Param("param") ProjectOrderQueryParam projectOrderQueryParam);

}

package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderRights;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderRightsQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderRightsQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 订单维权 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface OrderRightsMapper extends BaseMapper<OrderRights> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderRightsQueryVo getOrderRightsById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param orderRightsQueryParam
     * @return
     */
    IPage<OrderRightsQueryVo> getOrderRightsPageList(@Param("page") Page page, @Param("param") OrderRightsQueryParam orderRightsQueryParam);

}

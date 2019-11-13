package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderCheck;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCheckQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCheckQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 订单验收信息 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface OrderCheckMapper extends BaseMapper<OrderCheck> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderCheckQueryVo getOrderCheckById(Serializable id);

    /**
     * 根据OrderID获取查询对象
     *
     * @param orderId
     * @return
     */
    OrderCheckQueryVo getOrderCheckByOrderId(Serializable orderId);

    /**
     * 获取分页对象
     *
     * @param page
     * @param orderCheckQueryParam
     * @return
     */
    IPage<OrderCheckQueryVo> getOrderCheckPageList(@Param("page") Page page, @Param("param") OrderCheckQueryParam orderCheckQueryParam);

}

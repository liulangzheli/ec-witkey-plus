package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderComment;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderCommentQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderCommentQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 订单评价 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface OrderCommentMapper extends BaseMapper<OrderComment> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OrderCommentQueryVo getOrderCommentById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param orderCommentQueryParam
     * @return
     */
    IPage<OrderCommentQueryVo> getOrderCommentPageList(@Param("page") Page page, @Param("param") OrderCommentQueryParam orderCommentQueryParam);

}

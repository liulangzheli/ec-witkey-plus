package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderProgress;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderProgressQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderProgressQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 订单项目进度信息 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface OrderProgressMapper extends BaseMapper<OrderProgress> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        OrderProgressQueryVo getOrderProgressById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param orderProgressQueryParam
             * @return
             */
            IPage<OrderProgressQueryVo> getOrderProgressPageList(@Param("page") Page page, @Param("param") OrderProgressQueryParam orderProgressQueryParam);
    
        }

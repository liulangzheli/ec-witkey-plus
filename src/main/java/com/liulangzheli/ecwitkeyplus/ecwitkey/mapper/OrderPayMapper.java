package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderPay;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderPayQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderPayQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 订单付款信息 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface OrderPayMapper extends BaseMapper<OrderPay> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        OrderPayQueryVo getOrderPayById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param orderPayQueryParam
             * @return
             */
            IPage<OrderPayQueryVo> getOrderPayPageList(@Param("page") Page page, @Param("param") OrderPayQueryParam orderPayQueryParam);
    
        }

package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.OrderBidding;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.OrderBiddingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.OrderBiddingQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 订单竞标信息 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface OrderBiddingMapper extends BaseMapper<OrderBidding> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        OrderBiddingQueryVo getOrderBiddingById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param orderBiddingQueryParam
             * @return
             */
            IPage<OrderBiddingQueryVo> getOrderBiddingPageList(@Param("page") Page page, @Param("param") OrderBiddingQueryParam orderBiddingQueryParam);
    
        }

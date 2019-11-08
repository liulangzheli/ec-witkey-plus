package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

/**
 * <pre>
 * 订单评价 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderCommentQueryParam对象", description = "订单评价查询参数")
        public class OrderCommentQueryParam extends OrderQueryParam {
        private static final long serialVersionUID = 1L;
}

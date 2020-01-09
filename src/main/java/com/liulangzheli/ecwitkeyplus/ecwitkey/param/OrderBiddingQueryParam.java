package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

import java.util.List;

/**
 * <pre>
 * 订单竞标信息 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderBiddingQueryParam对象", description = "订单竞标信息查询参数")
        public class OrderBiddingQueryParam extends OrderQueryParam {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;

        @ApiModelProperty(value = "雇主id")
        private Long ownerId;

        @ApiModelProperty(value = "项目id")
        private Long orderId;

        @ApiModelProperty(value = "项目状态List")
        private Integer orderState;

        @ApiModelProperty(value = "项目状态List")
        private String orderStates;

        @ApiModelProperty(value = "项目状态List")
        private List<String> orderStatesList;

}

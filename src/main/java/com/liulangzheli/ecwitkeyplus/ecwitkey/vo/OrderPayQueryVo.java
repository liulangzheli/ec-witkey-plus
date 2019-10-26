package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 订单付款信息 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OrderPayQueryVo对象", description = "订单付款信息查询参数")
public class OrderPayQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long payId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "付款时间")
    private Date payTime;

    @ApiModelProperty(value = "订单总额")
    private Integer amount;

    @ApiModelProperty(value = "优惠金额")
    private Integer discount;

    @ApiModelProperty(value = "实际付款")
    private Integer actualAmount;

    @ApiModelProperty(value = "流水号")
    private Integer flowNum;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "支付方式,1、银行卡 2、支付宝 3、微信")
    private Integer payMethod;

    @ApiModelProperty(value = "交易状态，0:待付款 1：交易成功 2：交易失败 3、付款超时 4、退款")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remark;

}
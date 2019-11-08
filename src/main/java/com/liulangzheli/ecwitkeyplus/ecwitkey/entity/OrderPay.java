package com.liulangzheli.ecwitkeyplus.ecwitkey.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.liulangzheli.ecwitkeyplus.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 订单付款信息
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "OrderPay对象", description = "订单付款信息")
public class OrderPay extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
    
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

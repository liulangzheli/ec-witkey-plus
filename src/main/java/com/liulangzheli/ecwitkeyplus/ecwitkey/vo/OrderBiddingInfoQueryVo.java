package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 项目竞标信息 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OrderBiddingInfoQueryVo", description = "项目竞标信息")
public class OrderBiddingInfoQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "会员ID")
    private Long userId;

    @ApiModelProperty(value = "投标时间")
    private Date createTime;

    @ApiModelProperty(value = "中标状态，0：等待选标 1：超时 2：选中 3、未中标")
    private Integer state;

    @ApiModelProperty(value = "留言")
    private String message;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "项目发布者")
    private String ownerId;

    @ApiModelProperty(value = "订单状态")
    private String orderState;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "状态，0：禁用，1：启用，2：锁定")
    private Integer userState;

}
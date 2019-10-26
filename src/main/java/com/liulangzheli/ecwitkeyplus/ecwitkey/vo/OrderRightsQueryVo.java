package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 订单维权 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OrderRightsQueryVo对象", description = "订单维权查询参数")
public class OrderRightsQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long rightsId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "会员ID")
    private Long userId;

    @ApiModelProperty(value = "维权类型")
    private Integer rightsType;

    @ApiModelProperty(value = "说明")
    private String intro;

    @ApiModelProperty(value = "维权证明1")
    private String source1;

    @ApiModelProperty(value = "维权证明2")
    private String source2;

    @ApiModelProperty(value = "维权证明3")
    private String source3;

    @ApiModelProperty(value = "维权证明4")
    private String source4;

    @ApiModelProperty(value = "维权证明5")
    private String source5;

    @ApiModelProperty(value = "维权证明6")
    private String source6;

    @ApiModelProperty(value = "发起时间")
    private Date creatTime;

    @ApiModelProperty(value = "验收状态 0：待审核 1：审核通过 2：驳回")
    private Integer state;

    @ApiModelProperty(value = "审核时间")
    private Date protectTime;

    @ApiModelProperty(value = "审核人")
    private Long roleId;

    @ApiModelProperty(value = "审核意见")
    private String suggest;

    @ApiModelProperty(value = "备注")
    private String remark;

}
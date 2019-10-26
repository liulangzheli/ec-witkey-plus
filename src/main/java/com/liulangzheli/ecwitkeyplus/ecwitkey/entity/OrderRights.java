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
 * <p>
 * 订单维权
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderRights对象", description = "订单维权")
public class OrderRights extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "rights_id", type = IdType.ID_WORKER)
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

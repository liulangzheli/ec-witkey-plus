package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 项目审核 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProjectExamineQueryVo对象", description = "项目审核查询参数")
public class ProjectExamineQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long examineId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "审核状态，0：待审核 1：审核通过 2:  驳回 3：审核超时")
    private Integer state;

    @ApiModelProperty(value = "审核人")
    private Long roleId;

    @ApiModelProperty(value = "审核时间")
    private Date examineTime;

    @ApiModelProperty(value = "备注")
    private String remark;

}
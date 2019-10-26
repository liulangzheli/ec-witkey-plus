package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 项目类型要求 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProjectRequirementQueryVo对象", description = "项目类型要求查询参数")
public class ProjectRequirementQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long requirementId;

    @ApiModelProperty(value = "项目类型ID")
    private Long categoryId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "单体数量")
    private Integer qty;

    @ApiModelProperty(value = "计入方式,默认为0，0:表示以地上总建筑面积计入 1:表示以总投资金额计入")
    private Integer countType;

    @ApiModelProperty(value = "地上总建筑面积,单位平米")
    private Float area;

    @ApiModelProperty(value = "总投资金额,单位万元")
    private Float amount;

    @ApiModelProperty(value = "备注")
    private String remark;

}
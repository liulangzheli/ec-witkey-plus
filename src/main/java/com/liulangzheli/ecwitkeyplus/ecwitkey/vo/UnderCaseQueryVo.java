package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 线下案例 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UnderCaseQueryVo对象", description = "线下案例查询参数")
public class UnderCaseQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long caseId;

    @ApiModelProperty(value = "会员ID")
    private Long userId;

    @ApiModelProperty(value = "项目名称")
    private String caseName;

    @ApiModelProperty(value = "项目类型ID")
    private Long categoryId;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "省")
    private Integer province;

    @ApiModelProperty(value = "市")
    private Integer city;

    @ApiModelProperty(value = "软件")
    private String softSupplier;

    @ApiModelProperty(value = "介绍")
    private String intro;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "备注")
    private String remark;

}
package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 项目订单 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProjectOrderUserQueryVo对象", description = "雇主项目订单查询参数")
public class ProjectOrderUserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户/雇主id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "付款完成时间")
    private Date payTime;

    @ApiModelProperty(value = "审核时间")
    private Date examineTime;

    @ApiModelProperty(value = "选标完成时间")
    private Date pickTime;

    @ApiModelProperty(value = "验收完成时间")
    private Date checkTime;

    @ApiModelProperty(value = "项目用途")
    private String useType;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "项目类型名称")
    private String projTypeName;

    @ApiModelProperty(value = "项目类别名称")
    private String cateName;

    @ApiModelProperty(value = "专业要求,用|隔开")
    private String major;

    @ApiModelProperty(value = "项目所在地（省）")
    private String province;

    @ApiModelProperty(value = "项目所在地（市）")
    private String city;

    @ApiModelProperty(value = "截止报名时间")
    private Date endTime;

    @ApiModelProperty(value = "交付周期 单位天")
    private Integer period;

    @ApiModelProperty(value = "预算费用")
    private Float amount;

    @ApiModelProperty(value = "软件供应商")
    private String softSupplier;

    @ApiModelProperty(value = "软件名称")
    private String softName;

    @ApiModelProperty(value = "详细描述")
    private String intro;

    @ApiModelProperty(value = "订单状态 0：发布 1：进行中 2:  完成 3、关闭")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "昵称")
    private String username;

    @ApiModelProperty(value = "用户类型，0：个人/团队，1：企业")
    private Integer userType;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "企业组织机构代码")
    private String licenseId;

    @ApiModelProperty(value = "身份证号")
    private String idNum;

}
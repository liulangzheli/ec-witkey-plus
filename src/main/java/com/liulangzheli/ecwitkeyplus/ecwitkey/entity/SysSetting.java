package com.liulangzheli.ecwitkeyplus.ecwitkey.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 系统设置
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysSetting对象", description = "系统设置")
public class SysSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "settting_id", type = IdType.ID_WORKER)
    private Long setttingId;

    @ApiModelProperty(value = "软件供应商")
    private String softSupplier;

    @ApiModelProperty(value = "公司类型")
    private String companyType;

    @ApiModelProperty(value = "合作地产")
    private String estate;

    @ApiModelProperty(value = "热搜关键词")
    private String hotKey;

    @ApiModelProperty(value = "维权类型")
    private String protectType;

    @ApiModelProperty(value = "热门评价标签")
    private String hotTag;

    @ApiModelProperty(value = "选标时间限制")
    private Integer bLimit;

    @ApiModelProperty(value = "审核时间限制")
    private Integer eLimit;

    @ApiModelProperty(value = "付款时间限制")
    private Integer pLimit;

    @ApiModelProperty(value = "域名")
    private Integer website;

    @ApiModelProperty(value = "备案号")
    private String recordNum;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "客服QQ")
    private String serNum;

    @ApiModelProperty(value = "管理员角色类型")
    private Integer roleType;

    @ApiModelProperty(value = "备注")
    private String remark;

}

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
 * 类别管理
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Category对象", description = "类别管理")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "category_id", type = IdType.ID_WORKER)
    private Long categoryId;

    @ApiModelProperty(value = "类别性质 0：需求分类 1：项目类型 2：项目专业 3：文章分类")
    private Integer categoryType;

    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
    private String cateName;

    @ApiModelProperty(value = "父级分类ID")
    private Long cateParentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "分类介绍")
    @NotBlank(message = "分类介绍不能为空")
    private String intro;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "备注")
    private String remark;

}

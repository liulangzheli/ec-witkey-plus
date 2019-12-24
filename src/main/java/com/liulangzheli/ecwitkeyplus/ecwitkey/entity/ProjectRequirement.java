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
 * <pre>
 * 项目类型要求
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "ProjectRequirement对象", description = "项目类型要求")
public class ProjectRequirement extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
                        @ApiModelProperty(value = "项目类型ID0")
                                                                private Long categoryId0;
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

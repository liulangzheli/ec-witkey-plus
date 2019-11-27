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
 * <pre>
 * 项目订单
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "ProjectOrder对象", description = "项目订单")
public class ProjectOrder extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
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
                        
                        @ApiModelProperty(value = "分类id")
                                                                private Long categoryId;
                        
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
                        
        }

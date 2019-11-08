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
 * 线下案例
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "UnderCase对象", description = "线下案例")
public class UnderCase extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
    
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

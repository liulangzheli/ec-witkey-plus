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
 * 项目资料
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "ProjectSource对象", description = "项目资料")
public class ProjectSource extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
    
                        @ApiModelProperty(value = "资料原名称")
                                                                private String originalName;
                        
                        @ApiModelProperty(value = "资料现名称")
                                                                private String sourceName;
                        
                        @ApiModelProperty(value = "文件格式")
                                                                private String format;
                        
                        @ApiModelProperty(value = "资料大小")
                                                                private Integer size;
                        
                        @ApiModelProperty(value = "订单ID")
                                                                private Long orderId;
                        
                        @ApiModelProperty(value = "备注")
                                                                private String remark;
                        
        }

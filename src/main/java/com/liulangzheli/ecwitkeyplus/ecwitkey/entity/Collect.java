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
 * 收藏的服务商
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "Collect对象", description = "收藏的服务商")
public class Collect extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
    
                        @ApiModelProperty(value = "会员ID")
                                                                private Long userId;
                        
                        @ApiModelProperty(value = "服务商ID")
                                                                private Long supplierId;
                        
                        @ApiModelProperty(value = "创建时间")
                                                                private Date createTime;
                        
                        @ApiModelProperty(value = "服务商标签")
                                                                private String tag;
                        
                        @ApiModelProperty(value = "备注")
                                                                private String remark;
                        
        }

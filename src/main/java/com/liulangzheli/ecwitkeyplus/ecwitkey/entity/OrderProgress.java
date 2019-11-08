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
 * 订单项目进度信息
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "OrderProgress对象", description = "订单项目进度信息")
public class OrderProgress extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
                                        private Long id;
    
                        @ApiModelProperty(value = "开始时间")
                                                                private Date startTime;
                        
                        @ApiModelProperty(value = "结束时间")
                                                                private Date endTime;
                        
                        @ApiModelProperty(value = "进度说明")
                                                                private String intro;
                        
                        @ApiModelProperty(value = "资料图纸信息ID")
                                                                private Long sourceId;
                        
                        @ApiModelProperty(value = "订单ID")
                                                                private Long orderId;
                        
                        @ApiModelProperty(value = "备注")
                                                                private String remark;
                        
        }

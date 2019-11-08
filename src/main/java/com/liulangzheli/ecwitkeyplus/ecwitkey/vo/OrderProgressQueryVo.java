package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 订单项目进度信息 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "OrderProgressQueryVo对象", description = "订单项目进度信息查询参数")
public class OrderProgressQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
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
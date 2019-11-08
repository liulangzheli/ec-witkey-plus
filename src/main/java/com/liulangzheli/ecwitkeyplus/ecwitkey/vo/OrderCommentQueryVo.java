package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 订单评价 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "OrderCommentQueryVo对象", description = "订单评价查询参数")
public class OrderCommentQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
                                                                        private Long id;
    
                                        @ApiModelProperty(value = "评价内容")
                                                        private String content;
    
                                        @ApiModelProperty(value = "技能评分")
                                                        private Integer technicalGrade;
    
                                        @ApiModelProperty(value = "服务评分")
                                                        private Integer serverGrade;
    
                                        @ApiModelProperty(value = "综合评分")
                                                        private Integer multiGrade;
    
                                        @ApiModelProperty(value = "会员ID")
                                                        private Long userId;
    
                                        @ApiModelProperty(value = "订单ID")
                                                        private Long orderId;
    
                                        @ApiModelProperty(value = "评价标签")
                                                        private String commentTag;
    
                                        @ApiModelProperty(value = "创建时间")
                                                        private Date createTime;
    
                                        @ApiModelProperty(value = "备注")
                                                        private String remark;
        
            }
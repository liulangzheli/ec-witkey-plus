package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 收藏的服务商 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "CollectQueryVo对象", description = "收藏的服务商查询参数")
public class CollectQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
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
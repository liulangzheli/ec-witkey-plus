package com.liulangzheli.ecwitkeyplus.foobar.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * FooBar 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "FooBarQueryVo对象", description = "FooBar查询参数")
public class FooBarQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
                                                                        private Long id;
    
                                        @ApiModelProperty(value = "名称")
                                                        private String name;
    
                                        @ApiModelProperty(value = "Foo")
                                                        private String foo;
    
                                        @ApiModelProperty(value = "Bar")
                                                        private String bar;
    
                                        @ApiModelProperty(value = "备注")
                                                        private String remark;
    
                                        @ApiModelProperty(value = "状态，0：禁用，1：启用")
                                                        private Integer state;
    
                                        @ApiModelProperty(value = "版本")
                                                        private Integer version;
    
                                        @ApiModelProperty(value = "创建时间")
                                                        private Date createTime;
    
                                        @ApiModelProperty(value = "修改时间")
                                                        private Date updateTime;
        
            }
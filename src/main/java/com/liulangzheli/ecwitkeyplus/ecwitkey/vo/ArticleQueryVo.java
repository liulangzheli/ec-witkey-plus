package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 文章 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "ArticleQueryVo对象", description = "文章查询参数")
public class ArticleQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
                                                                        private Long id;
    
                                        @ApiModelProperty(value = "标题")
                                                        private String title;
    
                                        @ApiModelProperty(value = "发布时间")
                                                        private Date createTime;
    
                                        @ApiModelProperty(value = "文章内容")
                                                        private String content;
    
                                        @ApiModelProperty(value = "发布人")
                                                        private Long userId;
    
                                        @ApiModelProperty(value = "备注")
                                                        private String remark;
        
            }
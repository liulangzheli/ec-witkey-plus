package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 类别管理 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "CategoryQueryVo对象", description = "类别管理查询参数")
public class CategoryQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
                                                                        private Long id;
    
                                        @ApiModelProperty(value = "类别性质 0：需求分类 1：项目类型 2：项目专业 3：文章分类")
                                                        private Integer categoryType;
    
                                        @ApiModelProperty(value = "名称")
                                                        private String cateName;
    
                                        @ApiModelProperty(value = "父级分类ID")
                                                        private Long cateParentId;
    
                                        @ApiModelProperty(value = "排序")
                                                        private Integer sort;
    
                                        @ApiModelProperty(value = "分类介绍")
                                                        private String intro;
    
                                        @ApiModelProperty(value = "创建时间")
                                                        private Date createTime;
    
                                        @ApiModelProperty(value = "备注")
                                                        private String remark;
        
            }
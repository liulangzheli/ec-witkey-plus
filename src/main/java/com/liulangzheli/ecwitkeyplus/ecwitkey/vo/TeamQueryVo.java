package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

        import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
            import lombok.Data;
    import lombok.experimental.Accessors;
    import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 团队成员 查询结果对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-27
 */
        @Data
    @Accessors(chain = true)
    @ApiModel(value = "TeamQueryVo对象", description = "团队成员查询参数")
public class TeamQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
                                                @ApiModelProperty(value = "主键")
                                                                        private Long id;
    
                                        @ApiModelProperty(value = "姓名")
                                                        private String tname;
    
                                        @ApiModelProperty(value = "加入工作时间")
                                                        private Date jobtime;
    
                                        @ApiModelProperty(value = "入职时间")
                                                        private Date entrytime;
    
                                        @ApiModelProperty(value = "专业")
                                                        private String major;
    
                                        @ApiModelProperty(value = "省")
                                                        private String province;
    
                                        @ApiModelProperty(value = "市")
                                                        private String city;
        
            }
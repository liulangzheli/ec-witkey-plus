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
 * 团队成员
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-27
 */
@Data
@Accessors(chain = true)
        @EqualsAndHashCode(callSuper = true)
    @ApiModel(value = "Team对象", description = "团队成员")
public class Team extends BaseEntity {

private static final long serialVersionUID = 1L;

                            @ApiModelProperty(value = "主键")
                                            @TableId(value = "id", type = IdType.ID_WORKER)
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

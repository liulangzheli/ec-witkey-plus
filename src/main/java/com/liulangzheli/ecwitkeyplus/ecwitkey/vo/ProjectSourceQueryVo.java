package com.liulangzheli.ecwitkeyplus.ecwitkey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 项目资料 查询结果对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProjectSourceQueryVo对象", description = "项目资料查询参数")
public class ProjectSourceQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long sourceId;

    @ApiModelProperty(value = "资料原名称")
    private String originalName;

    @ApiModelProperty(value = "资料现名称")
    private String sourceName;

    @ApiModelProperty(value = "文件格式")
    private String format;

    @ApiModelProperty(value = "资料大小")
    private Integer size;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "备注")
    private String remark;

}
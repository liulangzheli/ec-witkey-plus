package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

/**
 * <pre>
 * 类别管理 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CategoryQueryParam对象", description = "类别管理查询参数")
public class CategoryQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类别性质")
    private int categoryType;

    @ApiModelProperty(value = "父级分类ID")
    private int cateParentId;
}

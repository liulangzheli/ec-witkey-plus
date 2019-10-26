package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.QueryParam;

/**
 * <p>
 * 订单项目进度信息 查询参数对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderProgressQueryParam对象", description = "订单项目进度信息查询参数")
public class OrderProgressQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}

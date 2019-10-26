package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.QueryParam;

/**
 * <p>
 * 系统设置 查询参数对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysSettingQueryParam对象", description = "系统设置查询参数")
public class SysSettingQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}

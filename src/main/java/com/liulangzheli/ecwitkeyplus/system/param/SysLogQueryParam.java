package com.liulangzheli.ecwitkeyplus.system.param;

import com.liulangzheli.ecwitkeyplus.common.param.QueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志 查询参数对象
 * </p>
 *
 * @author liulangzheli
 * @date 2019-10-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysLogQueryParam对象", description = "系统日志查询参数")
public class SysLogQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}

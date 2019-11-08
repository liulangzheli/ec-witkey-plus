package com.liulangzheli.ecwitkeyplus.system.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.QueryParam;

/**
 * <pre>
 * 系统用户 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-09
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserQueryParam对象", description = "系统用户查询参数")
        public class SysUserQueryParam extends QueryParam {
        private static final long serialVersionUID = 1L;
}

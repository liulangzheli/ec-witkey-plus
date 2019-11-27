package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

/**
 * <pre>
 * 团队成员 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TeamQueryParam对象", description = "团队成员查询参数")
        public class TeamQueryParam extends OrderQueryParam {
        private static final long serialVersionUID = 1L;
}

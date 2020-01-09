package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

import java.util.List;

/**
 * <pre>
 * 项目订单 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProjectOrderQueryParam对象", description = "项目订单查询参数")
        public class ProjectOrderQueryParam extends OrderQueryParam {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;

        @ApiModelProperty(value = "状态")
        private int state;

        @ApiModelProperty(value = "状态List")
        private String states;

        @ApiModelProperty(value = "状态List")
        private List<String> stateList;

        @ApiModelProperty(value = "项目专业")
        private String major;
}

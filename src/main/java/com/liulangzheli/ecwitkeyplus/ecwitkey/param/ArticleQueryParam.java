package com.liulangzheli.ecwitkeyplus.ecwitkey.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.OrderQueryParam;

/**
 * <pre>
 * 文章 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ArticleQueryParam对象", description = "文章查询参数")
        public class ArticleQueryParam extends OrderQueryParam {
        private static final long serialVersionUID = 1L;
}

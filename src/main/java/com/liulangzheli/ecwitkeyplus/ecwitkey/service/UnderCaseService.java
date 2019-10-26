package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.UnderCase;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.UnderCaseQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.UnderCaseQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 线下案例 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface UnderCaseService extends BaseService<UnderCase> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    UnderCaseQueryVo getUnderCaseById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param underCaseQueryParam
     * @return
     */
    Paging<UnderCaseQueryVo> getUnderCasePageList(UnderCaseQueryParam underCaseQueryParam) throws Exception;

}

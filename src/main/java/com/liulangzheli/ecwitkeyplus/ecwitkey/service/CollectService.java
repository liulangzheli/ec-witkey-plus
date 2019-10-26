package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Collect;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CollectQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CollectQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 收藏的服务商 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface CollectService extends BaseService<Collect> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CollectQueryVo getCollectById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param collectQueryParam
     * @return
     */
    Paging<CollectQueryVo> getCollectPageList(CollectQueryParam collectQueryParam) throws Exception;

}

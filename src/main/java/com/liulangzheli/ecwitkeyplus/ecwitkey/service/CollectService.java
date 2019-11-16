package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Collect;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CollectQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CollectQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 收藏的服务商 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface CollectService extends BaseService<Collect> {

    /**
     * 保存
     *
     * @param collect
     * @return
     * @throws Exception
     */
    boolean saveCollect(Collect collect) throws Exception;

    /**
     * 修改
     *
     * @param collect
     * @return
     * @throws Exception
     */
    boolean updateCollect(Collect collect) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCollect(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CollectQueryVo getCollectById(Serializable id) throws Exception;

    /**
     * 根据USERID获取查询对象
     *
     * @param userId
     * @return
     * @throws Exception
     */
    CollectQueryVo getCollectByUserId(Serializable userId) throws Exception;

    /**
     * 获取分页对象
     *
     * @param collectQueryParam
     * @return
     * @throws Exception
     */
    Paging<CollectQueryVo> getCollectPageList(CollectQueryParam collectQueryParam) throws Exception;

}

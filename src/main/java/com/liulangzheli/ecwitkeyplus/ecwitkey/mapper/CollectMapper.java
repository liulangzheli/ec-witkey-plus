package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Collect;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CollectQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CollectQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 收藏的服务商 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface CollectMapper extends BaseMapper<Collect> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CollectQueryVo getCollectById(Serializable id);

    /**
     * 根据USERID获取查询对象
     *
     * @param userId
     * @return
     */
    CollectQueryVo getCollectByUserId(Serializable userId);

    /**
     * 获取分页对象
     *
     * @param page
     * @param collectQueryParam
     * @return
     */
    IPage<CollectQueryVo> getCollectPageList(@Param("page") Page page, @Param("param") CollectQueryParam collectQueryParam);

}

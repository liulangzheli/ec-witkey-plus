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
 * <p>
 * 收藏的服务商 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
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
     * 获取分页对象
     *
     * @param page
     * @param collectQueryParam
     * @return
     */
    IPage<CollectQueryVo> getCollectPageList(@Param("page") Page page, @Param("param") CollectQueryParam collectQueryParam);

}

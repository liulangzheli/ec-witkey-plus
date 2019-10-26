package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.UnderCase;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.UnderCaseQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.UnderCaseQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 线下案例 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Repository
public interface UnderCaseMapper extends BaseMapper<UnderCase> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    UnderCaseQueryVo getUnderCaseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param underCaseQueryParam
     * @return
     */
    IPage<UnderCaseQueryVo> getUnderCasePageList(@Param("page") Page page, @Param("param") UnderCaseQueryParam underCaseQueryParam);

}

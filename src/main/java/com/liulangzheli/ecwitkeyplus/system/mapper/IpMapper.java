package com.liulangzheli.ecwitkeyplus.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.system.entity.Ip;
import com.liulangzheli.ecwitkeyplus.system.param.IpQueryParam;
import com.liulangzheli.ecwitkeyplus.system.vo.IpQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * IP地址 Mapper 接口
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
@Repository
public interface IpMapper extends BaseMapper<Ip> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    IpQueryVo getIpById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param ipQueryParam
     * @return
     */
    IPage<IpQueryVo> getIpPageList(@Param("page") Page page, @Param("param") IpQueryParam ipQueryParam);

}

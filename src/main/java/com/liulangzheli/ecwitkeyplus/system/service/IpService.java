package com.liulangzheli.ecwitkeyplus.system.service;

import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.Ip;
import com.liulangzheli.ecwitkeyplus.system.param.IpQueryParam;
import com.liulangzheli.ecwitkeyplus.system.vo.IpQueryVo;

import java.io.Serializable;

/**
 * <p>
 * IP地址 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
public interface IpService extends BaseService<Ip> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    IpQueryVo getIpById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param ipQueryParam
     * @return
     */
    Paging<IpQueryVo> getIpPageList(IpQueryParam ipQueryParam) throws Exception;

}

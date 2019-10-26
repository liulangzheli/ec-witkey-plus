package com.liulangzheli.ecwitkeyplus.system.service;

import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.SysUser;
import com.liulangzheli.ecwitkeyplus.system.param.SysUserQueryParam;
import com.liulangzheli.ecwitkeyplus.system.vo.SysUserQueryVo;

import java.io.Serializable;

/**
 * <p>
 * SystemUser 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SysUserQueryVo getSysUserById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysUserQueryParam
     * @return
     */
    Paging<SysUserQueryVo> getSysUserPageList(SysUserQueryParam sysUserQueryParam) throws Exception;

}

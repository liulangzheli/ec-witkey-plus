package com.liulangzheli.ecwitkeyplus.system.service;

import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.SysLog;
import com.liulangzheli.ecwitkeyplus.system.param.SysLogQueryParam;
import com.liulangzheli.ecwitkeyplus.system.vo.SysLogQueryVo;

import java.io.Serializable;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
public interface SysLogService extends BaseService<SysLog> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SysLogQueryVo getSysLogById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysLogQueryParam
     * @return
     */
    Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception;

}

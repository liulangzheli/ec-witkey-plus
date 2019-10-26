package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.SysSetting;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.SysSettingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.SysSettingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 * 系统设置 服务类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
public interface SysSettingService extends BaseService<SysSetting> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SysSettingQueryVo getSysSettingById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysSettingQueryParam
     * @return
     */
    Paging<SysSettingQueryVo> getSysSettingPageList(SysSettingQueryParam sysSettingQueryParam) throws Exception;

}

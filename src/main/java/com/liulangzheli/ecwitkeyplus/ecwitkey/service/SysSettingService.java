package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.SysSetting;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.SysSettingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.SysSettingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 系统设置 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface SysSettingService extends BaseService<SysSetting> {
            
                /**
                 * 保存
                 *
                 * @param sysSetting
                 * @return
                 * @throws Exception
                 */
                boolean saveSysSetting(SysSetting sysSetting) throws Exception;

                /**
                 * 修改
                 *
                 * @param sysSetting
                 * @return
                 * @throws Exception
                 */
                boolean updateSysSetting(SysSetting sysSetting) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteSysSetting(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        SysSettingQueryVo getSysSettingById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param sysSettingQueryParam
             * @return
             * @throws Exception
             */
            Paging<SysSettingQueryVo> getSysSettingPageList(SysSettingQueryParam sysSettingQueryParam) throws Exception;
    
        }

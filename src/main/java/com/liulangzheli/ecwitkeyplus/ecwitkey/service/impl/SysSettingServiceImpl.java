package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.SysSetting;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.SysSettingMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.SysSettingService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.SysSettingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.SysSettingQueryVo;
import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 系统设置 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class SysSettingServiceImpl extends BaseServiceImpl<SysSettingMapper, SysSetting> implements SysSettingService {

        @Autowired
        private SysSettingMapper sysSettingMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveSysSetting(SysSetting sysSetting) throws Exception {
                return super.save(sysSetting);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateSysSetting(SysSetting sysSetting) throws Exception {
                return super.updateById(sysSetting);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteSysSetting(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public SysSettingQueryVo getSysSettingById(Serializable id) throws Exception {
            return sysSettingMapper.getSysSettingById(id);
            }

            @Override
            public Paging<SysSettingQueryVo> getSysSettingPageList(SysSettingQueryParam sysSettingQueryParam) throws Exception {
            Page page = setPageParam(sysSettingQueryParam, OrderItem.desc("create_time"));
            IPage<SysSettingQueryVo> iPage = sysSettingMapper.getSysSettingPageList(page, sysSettingQueryParam);
            return new Paging(iPage);
            }
    
        }

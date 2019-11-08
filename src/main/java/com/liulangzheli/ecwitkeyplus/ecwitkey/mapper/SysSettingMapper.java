package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.SysSetting;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.SysSettingQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.SysSettingQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统设置 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface SysSettingMapper extends BaseMapper<SysSetting> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        SysSettingQueryVo getSysSettingById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param sysSettingQueryParam
             * @return
             */
            IPage<SysSettingQueryVo> getSysSettingPageList(@Param("page") Page page, @Param("param") SysSettingQueryParam sysSettingQueryParam);
    
        }

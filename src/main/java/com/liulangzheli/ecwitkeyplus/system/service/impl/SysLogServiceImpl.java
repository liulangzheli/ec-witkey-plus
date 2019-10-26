package com.liulangzheli.ecwitkeyplus.system.service.impl;

import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.SysLog;
import com.liulangzheli.ecwitkeyplus.system.mapper.SysLogMapper;
import com.liulangzheli.ecwitkeyplus.system.param.SysLogQueryParam;
import com.liulangzheli.ecwitkeyplus.system.service.SysLogService;
import com.liulangzheli.ecwitkeyplus.system.vo.SysLogQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;


/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-11
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLogQueryVo getSysLogById(Serializable id) throws Exception {
        return sysLogMapper.getSysLogById(id);
    }

    @Override
    public Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception {
        Page page = setPageParam(sysLogQueryParam, OrderItem.desc("create_time"));
        IPage<SysLogQueryVo> iPage = sysLogMapper.getSysLogPageList(page, sysLogQueryParam);
        return new Paging(iPage);
    }

}

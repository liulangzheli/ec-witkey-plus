package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectOrderMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectOrderService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
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
 * <p>
 * 项目订单 服务实现类
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectOrderServiceImpl extends BaseServiceImpl<ProjectOrderMapper, ProjectOrder> implements ProjectOrderService {

    @Autowired
    private ProjectOrderMapper projectOrderMapper;

    @Override
    public ProjectOrderQueryVo getProjectOrderById(Serializable id) throws Exception {
        return projectOrderMapper.getProjectOrderById(id);
    }

    @Override
    public Paging<ProjectOrderQueryVo> getProjectOrderPageList(ProjectOrderQueryParam projectOrderQueryParam) throws Exception {
        Page page = setPageParam(projectOrderQueryParam, OrderItem.desc("create_time"));
        IPage<ProjectOrderQueryVo> iPage = projectOrderMapper.getProjectOrderPageList(page, projectOrderQueryParam);
        return new Paging(iPage);
    }

}

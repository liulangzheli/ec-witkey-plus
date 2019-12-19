package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulangzheli.ecwitkeyplus.common.service.impl.BaseServiceImpl;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectOrder;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.ProjectOrderMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectOrderQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectOrderService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderQueryVo;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectOrderUserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


/**
 * <pre>
 * 项目订单 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
public class ProjectOrderServiceImpl extends BaseServiceImpl<ProjectOrderMapper, ProjectOrder> implements ProjectOrderService {

    @Autowired
    private ProjectOrderMapper projectOrderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveProjectOrder(ProjectOrder projectOrder) throws Exception {
        return super.save(projectOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long insertProjectOrder(ProjectOrder projectOrder) throws Exception {
        super.save(projectOrder);
        Long id = projectOrder.getId();
        return id;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProjectOrder(ProjectOrder projectOrder) throws Exception {
        return super.updateById(projectOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProjectOrder(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public ProjectOrderQueryVo getProjectOrderById(Serializable id) throws Exception {
        return projectOrderMapper.getProjectOrderById(id);
    }

    @Override
    public ProjectOrderUserQueryVo getProjectOrderUserById(Serializable id) throws Exception {
        return projectOrderMapper.getProjectOrderUserById(id);
    }

    @Override
    public ProjectOrderQueryVo getProjectOrderByUserId(Serializable userId) throws Exception {
        return projectOrderMapper.getProjectOrderByUserId(userId);
    }

    @Override
    public Paging<ProjectOrderQueryVo> getProjectOrderPageList(ProjectOrderQueryParam projectOrderQueryParam) throws Exception {
        Page page = setPageParam(projectOrderQueryParam, OrderItem.desc("create_time"));
        IPage<ProjectOrderQueryVo> iPage = projectOrderMapper.getProjectOrderPageList(page, projectOrderQueryParam);
        return new Paging(iPage);
    }

}

package com.liulangzheli.ecwitkeyplus.foobar.service.impl;

import com.liulangzheli.ecwitkeyplus.foobar.entity.FooBar;
import com.liulangzheli.ecwitkeyplus.foobar.mapper.FooBarMapper;
import com.liulangzheli.ecwitkeyplus.foobar.service.FooBarService;
import com.liulangzheli.ecwitkeyplus.foobar.param.FooBarQueryParam;
import com.liulangzheli.ecwitkeyplus.foobar.vo.FooBarQueryVo;
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
 * FooBar 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class FooBarServiceImpl extends BaseServiceImpl<FooBarMapper, FooBar> implements FooBarService {

        @Autowired
        private FooBarMapper fooBarMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveFooBar(FooBar fooBar) throws Exception {
                return super.save(fooBar);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateFooBar(FooBar fooBar) throws Exception {
                return super.updateById(fooBar);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteFooBar(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public FooBarQueryVo getFooBarById(Serializable id) throws Exception {
            return fooBarMapper.getFooBarById(id);
            }

            @Override
            public Paging<FooBarQueryVo> getFooBarPageList(FooBarQueryParam fooBarQueryParam) throws Exception {
            Page page = setPageParam(fooBarQueryParam, OrderItem.desc("create_time"));
            IPage<FooBarQueryVo> iPage = fooBarMapper.getFooBarPageList(page, fooBarQueryParam);
            return new Paging(iPage);
            }
    
        }

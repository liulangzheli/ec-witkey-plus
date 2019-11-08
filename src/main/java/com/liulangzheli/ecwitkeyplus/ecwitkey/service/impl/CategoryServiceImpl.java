package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Category;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.CategoryMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.CategoryService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CategoryQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CategoryQueryVo;
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
 * 类别管理 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
@Service
        public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {

        @Autowired
        private CategoryMapper categoryMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveCategory(Category category) throws Exception {
                return super.save(category);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateCategory(Category category) throws Exception {
                return super.updateById(category);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteCategory(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public CategoryQueryVo getCategoryById(Serializable id) throws Exception {
            return categoryMapper.getCategoryById(id);
            }

            @Override
            public Paging<CategoryQueryVo> getCategoryPageList(CategoryQueryParam categoryQueryParam) throws Exception {
            Page page = setPageParam(categoryQueryParam, OrderItem.desc("create_time"));
            IPage<CategoryQueryVo> iPage = categoryMapper.getCategoryPageList(page, categoryQueryParam);
            return new Paging(iPage);
            }
    
        }

package com.liulangzheli.ecwitkeyplus.foobar.service;

import com.liulangzheli.ecwitkeyplus.foobar.entity.FooBar;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.foobar.param.FooBarQueryParam;
import com.liulangzheli.ecwitkeyplus.foobar.vo.FooBarQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * FooBar 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface FooBarService extends BaseService<FooBar> {
            
                /**
                 * 保存
                 *
                 * @param fooBar
                 * @return
                 * @throws Exception
                 */
                boolean saveFooBar(FooBar fooBar) throws Exception;

                /**
                 * 修改
                 *
                 * @param fooBar
                 * @return
                 * @throws Exception
                 */
                boolean updateFooBar(FooBar fooBar) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteFooBar(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        FooBarQueryVo getFooBarById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param fooBarQueryParam
             * @return
             * @throws Exception
             */
            Paging<FooBarQueryVo> getFooBarPageList(FooBarQueryParam fooBarQueryParam) throws Exception;
    
        }

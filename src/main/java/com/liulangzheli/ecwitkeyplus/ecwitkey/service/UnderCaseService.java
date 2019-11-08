package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.UnderCase;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.UnderCaseQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.UnderCaseQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 线下案例 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
public interface UnderCaseService extends BaseService<UnderCase> {
            
                /**
                 * 保存
                 *
                 * @param underCase
                 * @return
                 * @throws Exception
                 */
                boolean saveUnderCase(UnderCase underCase) throws Exception;

                /**
                 * 修改
                 *
                 * @param underCase
                 * @return
                 * @throws Exception
                 */
                boolean updateUnderCase(UnderCase underCase) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteUnderCase(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        UnderCaseQueryVo getUnderCaseById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param underCaseQueryParam
             * @return
             * @throws Exception
             */
            Paging<UnderCaseQueryVo> getUnderCasePageList(UnderCaseQueryParam underCaseQueryParam) throws Exception;
    
        }

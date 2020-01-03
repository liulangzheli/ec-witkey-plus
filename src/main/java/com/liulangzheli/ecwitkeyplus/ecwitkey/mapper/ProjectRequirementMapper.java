package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementCategoryQueryVo;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 项目类型要求 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Repository
public interface ProjectRequirementMapper extends BaseMapper<ProjectRequirement> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        ProjectRequirementQueryVo getProjectRequirementById(Serializable id);

            /**
             * 根据ID获取查询对象
             *
             * @param orderId
             * @return
             */
            List<ProjectRequirementQueryVo> getProjectRequirementsByOrderId(Serializable orderId);

            /**
             * 获取分页对象
             *
             * @param page
             * @param projectRequirementQueryParam
             * @return
             */
            IPage<ProjectRequirementQueryVo> getProjectRequirementPageList(@Param("page") Page page, @Param("param") ProjectRequirementQueryParam projectRequirementQueryParam);
    


        /**
         * 根据orderId获取不分页对象
         *
         * @param orderId
         * @return
         */
        IPage<ProjectRequirementCategoryQueryVo> getProjectRequirementPageListByOrderId(Serializable orderId);

}

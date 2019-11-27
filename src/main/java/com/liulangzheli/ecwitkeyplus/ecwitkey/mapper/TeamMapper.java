package com.liulangzheli.ecwitkeyplus.ecwitkey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Team;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.TeamQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.TeamQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 团队成员 Mapper 接口
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-27
 */
@Repository
public interface TeamMapper extends BaseMapper<Team> {
    
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             */
        TeamQueryVo getTeamById(Serializable id);

            /**
             * 获取分页对象
             *
             * @param page
             * @param teamQueryParam
             * @return
             */
            IPage<TeamQueryVo> getTeamPageList(@Param("page") Page page, @Param("param") TeamQueryParam teamQueryParam);
    
        }

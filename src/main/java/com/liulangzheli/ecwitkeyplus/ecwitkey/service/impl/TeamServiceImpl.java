package com.liulangzheli.ecwitkeyplus.ecwitkey.service.impl;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Team;
import com.liulangzheli.ecwitkeyplus.ecwitkey.mapper.TeamMapper;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.TeamService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.TeamQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.TeamQueryVo;
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
 * 团队成员 服务实现类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-27
 */
@Slf4j
@Service
        public class TeamServiceImpl extends BaseServiceImpl<TeamMapper, Team> implements TeamService {

        @Autowired
        private TeamMapper teamMapper;
            
                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean saveTeam(Team team) throws Exception {
                return super.save(team);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean updateTeam(Team team) throws Exception {
                return super.updateById(team);
                }

                @Transactional(rollbackFor = Exception.class)
                @Override
                public boolean deleteTeam(Long id) throws Exception {
                return super.removeById(id);
                }
        
            @Override
            public TeamQueryVo getTeamById(Serializable id) throws Exception {
            return teamMapper.getTeamById(id);
            }

            @Override
            public Paging<TeamQueryVo> getTeamPageList(TeamQueryParam teamQueryParam) throws Exception {
            Page page = setPageParam(teamQueryParam, OrderItem.desc("create_time"));
            IPage<TeamQueryVo> iPage = teamMapper.getTeamPageList(page, teamQueryParam);
            return new Paging(iPage);
            }
    
        }

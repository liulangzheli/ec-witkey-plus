package com.liulangzheli.ecwitkeyplus.ecwitkey.service;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Team;
import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.TeamQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.TeamQueryVo;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 团队成员 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-27
 */
public interface TeamService extends BaseService<Team> {
            
                /**
                 * 保存
                 *
                 * @param team
                 * @return
                 * @throws Exception
                 */
                boolean saveTeam(Team team) throws Exception;

                /**
                 * 修改
                 *
                 * @param team
                 * @return
                 * @throws Exception
                 */
                boolean updateTeam(Team team) throws Exception;

                /**
                 * 删除
                 *
                 * @param id
                 * @return
                 * @throws Exception
                 */
                boolean deleteTeam(Long id) throws Exception;
        
            /**
             * 根据ID获取查询对象
             *
             * @param id
             * @return
             * @throws Exception
             */
        TeamQueryVo getTeamById(Serializable id) throws Exception;

            /**
             * 获取分页对象
             *
             * @param teamQueryParam
             * @return
             * @throws Exception
             */
            Paging<TeamQueryVo> getTeamPageList(TeamQueryParam teamQueryParam) throws Exception;
    
        }

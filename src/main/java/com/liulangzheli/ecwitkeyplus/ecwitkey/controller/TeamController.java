package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Team;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.TeamService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.TeamQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.TeamQueryVo;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
        import com.liulangzheli.ecwitkeyplus.common.controller.BaseController;
            import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiOperation;
    import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


        import javax.validation.Valid;
    
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.common.param.IdParam;

/**
 * <pre>
 * 团队成员 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-27
 */
@Slf4j
        @RestController
    @RequestMapping("/team")
@Api("团队成员 API")
        public class TeamController extends BaseController {
    
@Autowired
private TeamService teamService;

        /**
     * 添加团队成员
     */
    @PostMapping("/add")
            @ApiOperation(value = "添加Team对象", notes = "添加团队成员", response = ApiResult.class)
    public ApiResult<Boolean> addTeam(@Valid @RequestBody Team team) throws Exception {
                        boolean flag = teamService.saveTeam(team);
                    return ApiResult.result(flag);
            }

    /**
     * 修改团队成员
     */
    @PostMapping("/update")
            @ApiOperation(value = "修改Team对象", notes = "修改团队成员", response = ApiResult.class)
    public ApiResult<Boolean> updateTeam(@Valid @RequestBody Team team) throws Exception {
                        boolean flag = teamService.updateTeam(team);
                    return ApiResult.result(flag);
            }

    /**
     * 删除团队成员
     */
    @PostMapping("/delete/{id}")
            @ApiOperation(value = "删除Team对象", notes = "删除团队成员", response = ApiResult.class)
    public ApiResult<Boolean> deleteTeam(@PathVariable("id") Long id) throws Exception {
                        boolean flag = teamService.deleteTeam(id);
                    return ApiResult.result(flag);
            }

    /**
     * 获取团队成员
     */
    @GetMapping("/info/{id}")
            @ApiOperation(value = "获取Team对象详情", notes = "查看团队成员", response = TeamQueryVo.class)
    public ApiResult<TeamQueryVo> getTeam(@PathVariable("id") Long id) throws Exception {
        TeamQueryVo teamQueryVo = teamService.getTeamById(id);
            return ApiResult.ok(teamQueryVo);
            }

    /**
     * 团队成员分页列表
     */
    @PostMapping("/getPageList")
            @ApiOperation(value = "获取Team分页列表", notes = "团队成员分页列表", response = TeamQueryVo.class)
    public ApiResult<Paging<TeamQueryVo>> getTeamPageList(@Valid @RequestBody TeamQueryParam teamQueryParam) throws Exception {
            Paging<TeamQueryVo> paging = teamService.getTeamPageList(teamQueryParam);
            return ApiResult.ok(paging);
            }
    
        }


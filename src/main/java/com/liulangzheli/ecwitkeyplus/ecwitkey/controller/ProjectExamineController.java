package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectExamine;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectExamineService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectExamineQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectExamineQueryVo;
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
 * 项目审核 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
        @RestController
    @RequestMapping("/projectExamine")
@Api("项目审核 API")
        public class ProjectExamineController extends BaseController {
    
@Autowired
private ProjectExamineService projectExamineService;

        /**
     * 添加项目审核
     */
    @PostMapping("/add")
            @ApiOperation(value = "添加ProjectExamine对象", notes = "添加项目审核", response = ApiResult.class)
    public ApiResult<Boolean> addProjectExamine(@Valid @RequestBody ProjectExamine projectExamine) throws Exception {
                        boolean flag = projectExamineService.saveProjectExamine(projectExamine);
                    return ApiResult.result(flag);
            }

    /**
     * 修改项目审核
     */
    @PostMapping("/update")
            @ApiOperation(value = "修改ProjectExamine对象", notes = "修改项目审核", response = ApiResult.class)
    public ApiResult<Boolean> updateProjectExamine(@Valid @RequestBody ProjectExamine projectExamine) throws Exception {
                        boolean flag = projectExamineService.updateProjectExamine(projectExamine);
                    return ApiResult.result(flag);
            }

    /**
     * 删除项目审核
     */
    @PostMapping("/delete/{id}")
            @ApiOperation(value = "删除ProjectExamine对象", notes = "删除项目审核", response = ApiResult.class)
    public ApiResult<Boolean> deleteProjectExamine(@PathVariable("id") Long id) throws Exception {
                        boolean flag = projectExamineService.deleteProjectExamine(id);
                    return ApiResult.result(flag);
            }

    /**
     * 获取项目审核
     */
    @GetMapping("/info/{id}")
            @ApiOperation(value = "获取ProjectExamine对象详情", notes = "查看项目审核", response = ProjectExamineQueryVo.class)
    public ApiResult<ProjectExamineQueryVo> getProjectExamine(@PathVariable("id") Long id) throws Exception {
        ProjectExamineQueryVo projectExamineQueryVo = projectExamineService.getProjectExamineById(id);
            return ApiResult.ok(projectExamineQueryVo);
            }

    /**
     * 项目审核分页列表
     */
    @PostMapping("/getPageList")
            @ApiOperation(value = "获取ProjectExamine分页列表", notes = "项目审核分页列表", response = ProjectExamineQueryVo.class)
    public ApiResult<Paging<ProjectExamineQueryVo>> getProjectExaminePageList(@Valid @RequestBody ProjectExamineQueryParam projectExamineQueryParam) throws Exception {
            Paging<ProjectExamineQueryVo> paging = projectExamineService.getProjectExaminePageList(projectExamineQueryParam);
            return ApiResult.ok(paging);
            }
    
        }


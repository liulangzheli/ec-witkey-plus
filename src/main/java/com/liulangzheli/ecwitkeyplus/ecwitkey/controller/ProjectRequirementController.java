package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.ProjectRequirement;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.ProjectRequirementService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.ProjectRequirementQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.ProjectRequirementQueryVo;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import com.liulangzheli.ecwitkeyplus.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.common.param.IdParam;

/**
 * <p>
 * 项目类型要求 前端控制器
 * </p>
 *
 * @author liulangzheli
 * @since 2019-10-22
 */
@Slf4j
@RestController
@RequestMapping("/projectRequirement")
@Api("项目类型要求 API")
public class ProjectRequirementController extends BaseController {

    @Autowired
    private ProjectRequirementService projectRequirementService;

    /**
     * 添加项目类型要求
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ProjectRequirement对象", notes = "添加项目类型要求", response = ApiResult.class)
    public ApiResult<Boolean> addProjectRequirement(@Valid @RequestBody ProjectRequirement projectRequirement) throws Exception {
        boolean flag = projectRequirementService.save(projectRequirement);
        return ApiResult.result(flag);
    }

    /**
     * 修改项目类型要求
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ProjectRequirement对象", notes = "修改项目类型要求", response = ApiResult.class)
    public ApiResult<Boolean> updateProjectRequirement(@Valid @RequestBody ProjectRequirement projectRequirement) throws Exception {
        boolean flag = projectRequirementService.updateById(projectRequirement);
        return ApiResult.result(flag);
    }

    /**
     * 删除项目类型要求
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除ProjectRequirement对象", notes = "删除项目类型要求", response = ApiResult.class)
    public ApiResult<Boolean> deleteProjectRequirement(@Valid @RequestBody IdParam idParam) throws Exception {
        boolean flag = projectRequirementService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
     * 获取项目类型要求
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取ProjectRequirement对象详情", notes = "查看项目类型要求", response = ProjectRequirementQueryVo.class)
    public ApiResult<ProjectRequirementQueryVo> getProjectRequirement(@Valid @RequestBody IdParam idParam) throws Exception {
        ProjectRequirementQueryVo projectRequirementQueryVo = projectRequirementService.getProjectRequirementById(idParam.getId());
        return ApiResult.ok(projectRequirementQueryVo);
    }

    /**
     * 项目类型要求分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取ProjectRequirement分页列表", notes = "项目类型要求分页列表", response = ProjectRequirementQueryVo.class)
    public ApiResult<Paging<ProjectRequirementQueryVo>> getProjectRequirementPageList(@Valid @RequestBody ProjectRequirementQueryParam projectRequirementQueryParam) throws Exception {
        Paging<ProjectRequirementQueryVo> paging = projectRequirementService.getProjectRequirementPageList(projectRequirementQueryParam);
        return ApiResult.ok(paging);
    }

}


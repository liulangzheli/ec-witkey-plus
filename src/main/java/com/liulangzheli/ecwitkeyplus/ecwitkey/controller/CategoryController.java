package com.liulangzheli.ecwitkeyplus.ecwitkey.controller;

import com.liulangzheli.ecwitkeyplus.ecwitkey.entity.Category;
import com.liulangzheli.ecwitkeyplus.ecwitkey.service.CategoryService;
import com.liulangzheli.ecwitkeyplus.ecwitkey.param.CategoryQueryParam;
import com.liulangzheli.ecwitkeyplus.ecwitkey.vo.CategoryQueryVo;
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
 * 类别管理 前端控制器
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-11-04
 */
@Slf4j
        @RestController
    @RequestMapping("/category")
@Api("类别管理 API")
        public class CategoryController extends BaseController {
    
@Autowired
private CategoryService categoryService;

        /**
     * 添加类别管理
     */
    @PostMapping("/add")
            @ApiOperation(value = "添加Category对象", notes = "添加类别管理", response = ApiResult.class)
    public ApiResult<Boolean> addCategory(@Valid @RequestBody Category category) throws Exception {
                        boolean flag = categoryService.saveCategory(category);
                    return ApiResult.result(flag);
            }

    /**
     * 修改类别管理
     */
    @PostMapping("/update")
            @ApiOperation(value = "修改Category对象", notes = "修改类别管理", response = ApiResult.class)
    public ApiResult<Boolean> updateCategory(@Valid @RequestBody Category category) throws Exception {
                        boolean flag = categoryService.updateCategory(category);
                    return ApiResult.result(flag);
            }

    /**
     * 删除类别管理
     */
    @PostMapping("/delete/{id}")
            @ApiOperation(value = "删除Category对象", notes = "删除类别管理", response = ApiResult.class)
    public ApiResult<Boolean> deleteCategory(@PathVariable("id") Long id) throws Exception {
                        boolean flag = categoryService.deleteCategory(id);
                    return ApiResult.result(flag);
            }

    /**
     * 获取类别管理
     */
    @GetMapping("/info/{id}")
            @ApiOperation(value = "获取Category对象详情", notes = "查看类别管理", response = CategoryQueryVo.class)
    public ApiResult<CategoryQueryVo> getCategory(@PathVariable("id") Long id) throws Exception {
        CategoryQueryVo categoryQueryVo = categoryService.getCategoryById(id);
            return ApiResult.ok(categoryQueryVo);
            }

    /**
     * 类别管理分页列表
     */
    @PostMapping("/getPageList")
            @ApiOperation(value = "获取Category分页列表", notes = "类别管理分页列表", response = CategoryQueryVo.class)
    public ApiResult<Paging<CategoryQueryVo>> getCategoryPageList(@Valid @RequestBody CategoryQueryParam categoryQueryParam) throws Exception {
            Paging<CategoryQueryVo> paging = categoryService.getCategoryPageList(categoryQueryParam);
            return ApiResult.ok(paging);
            }
    
        }


package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.model.Permission;
import cn.microservice.www.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限控制器
 * @author MachineGeek
 */
@Api(tags = "权限接口")
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "添加权限")
    @PostMapping(value = "/add")
    public Result add(@RequestBody Permission Permission){
        permissionService.save(Permission);
        return Result.success(Permission.getId());
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping(value = "/deleteById")
    public Result deleteById(long id){
        permissionService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "修改权限")
    @PutMapping(value = "/modifyById")
    public Result modifyById(@RequestBody Permission Permission){
        return Result.success(permissionService.updateById(Permission));
    }

    @ApiOperation(value = "获取权限")
    @GetMapping(value = "/getById")
    public Result getById(long id){
        return Result.success(permissionService.getById(id));
    }

    @ApiOperation(value = "获取权限列表")
    @GetMapping(value = "/getList")
    public Result getList(){
        return Result.success(permissionService.list());
    }
}

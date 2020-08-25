package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.model.Role;
import cn.microservice.www.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器
 * @author MachineGeek
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping(value = "/account")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/add")
    public Result add(@RequestBody Role role){
        roleService.save(role);
        return Result.success(role.getId());
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping(value = "/deleteById")
    public Result deleteById(long id){
        roleService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping(value = "/modifyById")
    public Result modifyById(@RequestBody Role role){
        return Result.success(roleService.updateById(role));
    }

    @ApiOperation(value = "获取角色")
    @GetMapping(value = "/getById")
    public Result getById(long id){
        return Result.success(roleService.getById(id));
    }

    @ApiOperation(value = "获取角色列表")
    @GetMapping(value = "/getList")
    public Result getList(){
        return Result.success(roleService.list());
    }
}

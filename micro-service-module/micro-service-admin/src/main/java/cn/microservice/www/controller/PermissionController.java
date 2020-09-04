package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.dto.PageDto;
import cn.microservice.www.model.Permission;
import cn.microservice.www.service.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限控制器类
 * @author MachineGeek
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
    //@Autowired
    private PermissionService permissionSrv;

    @PostMapping(value = "/add")
    public Result add(@RequestBody Permission permission){
        permissionSrv.save(permission);
        return Result.ok(permission.getId());
    }

    @DeleteMapping(value = "/deleteById")
    public Result deleteById(@RequestParam(value = "id")String id){
        permissionSrv.removeById(id);
        return Result.ok();
    }

    @PutMapping(value = "/modify")
    public Result modify(@RequestBody Permission permission){
        permissionSrv.updateById(permission);
        return Result.ok();
    }

    @GetMapping(value = "/getById")
    public Result getById(@RequestParam(value = "id")String id){
        return Result.ok(permissionSrv.getById(id));
    }

    @GetMapping(value = "/page")
    public Result getByPage(PageDto pageDto){
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Permission::getPermissionName,pageDto.getKeyWord())
                .orderByDesc(Permission::getUpdateTime);
        return Result.ok(permissionSrv.page(new Page<Permission>(),queryWrapper));
    }

    @GetMapping(value = "/all")
    public Result all(){
        return Result.ok(permissionSrv.list());
    }
}
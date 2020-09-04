package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.dto.PageDto;
import cn.microservice.www.model.Role;
import cn.microservice.www.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器类
 * @author MachineGeek
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    //@Autowired
    private RoleService roleSrv;

    @PostMapping(value = "/add")
    public Result add(@RequestBody Role role){
        roleSrv.save(role);
        return Result.ok(role.getId());
    }

    @DeleteMapping(value = "/deleteById")
    public Result deleteById(@RequestParam(value = "id")String id){
        roleSrv.removeById(id);
        return Result.ok();
    }

    @PutMapping(value = "/modify")
    public Result modify(@RequestBody Role role){
        roleSrv.updateById(role);
        return Result.ok();
    }

    @GetMapping(value = "/getById")
    public Result getById(@RequestParam(value = "id")String id){
        return Result.ok(roleSrv.getById(id));
    }

    @GetMapping(value = "/page")
    public Result getByPage(PageDto pageDto){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Role::getRoleName,pageDto.getKeyWord())
                .orderByDesc(Role::getRoleSort);
        return Result.ok(roleSrv.page(new Page<Role>(),queryWrapper));
    }

    @GetMapping(value = "/all")
    public Result all(){
        return Result.ok(roleSrv.list());
    }
}

package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账户控制器
 * @author MachineGeek
 */
@Api(tags = "账户接口")
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "添加账户")
    @PostMapping(value = "/add")
    public Result add(@RequestBody Account account){
        accountService.save(account);
        return Result.success(account.getId());
    }

    @ApiOperation(value = "删除账户")
    @DeleteMapping(value = "/deleteById")
    public Result deleteById(long id){
        accountService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "修改账户")
    @PutMapping(value = "/modifyById")
    public Result modifyById(@RequestBody Account account){
        return Result.success(accountService.updateById(account));
    }

    @ApiOperation(value = "获取账户")
    @GetMapping(value = "/getById")
    public Result getById(long id){
        return Result.success(accountService.getById(id));
    }

    @ApiOperation(value = "获取账户列表")
    @GetMapping(value = "/getList")
    public Result getList(){
        return Result.success(accountService.list());
    }
}

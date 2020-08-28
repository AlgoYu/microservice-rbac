package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.dto.PageDto;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账户控制器类
 * @author MachineGeek
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountSrv;

    @PostMapping(value = "/add")
    public Result add(@RequestBody Account account){
        accountSrv.save(account);
        return Result.ok(account.getId());
    }

    @DeleteMapping(value = "/deleteById")
    public Result deleteById(@RequestParam(value = "id")String id){
        accountSrv.removeById(id);
        return Result.ok;
    }

    @PutMapping(value = "/modify")
    public Result modify(@RequestBody Account account){
        accountSrv.updateById(account);
        return Result.ok;
    }

    @GetMapping(value = "/getById")
    public Result getById(@RequestParam(value = "id")String id){
        return Result.ok(accountSrv.getById(id));
    }

    @GetMapping(value = "/page")
    public Result getByPage(PageDto pageDto){
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Account::getAccountNickname,pageDto.getKeyWord())
                .orderByDesc(Account::getUpdateTime);
        return Result.ok(accountSrv.page(new Page<Account>(),queryWrapper));
    }

    @GetMapping(value = "/all")
    public Result all(){
        return Result.ok(accountSrv.list());
    }
}

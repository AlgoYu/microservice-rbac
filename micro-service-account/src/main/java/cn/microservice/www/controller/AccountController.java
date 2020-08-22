package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.impl.AccountServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户控制器
 * @author MachineGeek
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountServiceImplement accountService;

    @PostMapping(value = "/add")
    public Result addAccount(@RequestBody Account account){
        accountService.save(account);
        return Result.success(account.getId());
    }
}

package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {
    @DubboReference(version = "1.0.0",url = "dubbo://127.0.0.1:22884")
    private AccountService accountService;

    @ResponseBody
    @GetMapping(value = "/dubboTest")
    public Result dubboTest(){
        log.info("hahahahaaha");
        List<Account> list = accountService.list();
        for (int i = 0; i < list.size(); i++){
            log.info(list.get(i).getAccountNickname());
        }
        return Result.ok(list);
    }
}

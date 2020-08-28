package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.AccountMapper;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 账户服务实现类
 * @author MachineGeek
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}

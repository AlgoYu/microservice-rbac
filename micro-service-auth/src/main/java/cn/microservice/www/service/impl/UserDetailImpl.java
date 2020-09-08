package cn.microservice.www.service.impl;

import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImpl implements UserDetailsService {
    @DubboReference(version = "1.0.0",check = false)
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getByName(username);
        if(account == null){
            throw new UsernameNotFoundException("该用户不存在！");
        }
        return new User(account.getAccountName(),account.getAccountPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,member"));
    }
}

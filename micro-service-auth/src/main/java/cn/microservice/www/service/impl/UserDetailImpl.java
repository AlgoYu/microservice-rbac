package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.AccountMapper;
import cn.microservice.www.mapper.RoleMapper;
import cn.microservice.www.model.Account;
import cn.microservice.www.model.Role;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class UserDetailImpl implements UserDetailsService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getAccountName,s);
        Account account = accountMapper.selectOne(queryWrapper);
        return new User(account.getAccountName(), account.getAccountPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }

    private Collection<GrantedAuthority> loadRolesByAccountId(Long accountId){
        List<Role> roles = roleMapper.selectRolesByAccountId(accountId);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}

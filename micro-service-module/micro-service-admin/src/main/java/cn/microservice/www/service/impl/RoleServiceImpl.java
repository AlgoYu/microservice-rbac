package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.RoleMapper;
import cn.microservice.www.model.Role;
import cn.microservice.www.service.AccountService;
import cn.microservice.www.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现类
 * @author MachineGeek
 */
@DubboService(version = "${service.version}",interfaceClass = RoleService.class)
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}

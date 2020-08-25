package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.RoleMapper;
import cn.microservice.www.model.Role;
import cn.microservice.www.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现类
 * @author MachineGeek
 */
@Service
public class RoleServiceImplement extends ServiceImpl<RoleMapper, Role> implements RoleService {
}

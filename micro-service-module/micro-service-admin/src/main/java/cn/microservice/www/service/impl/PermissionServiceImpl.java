package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.PermissionMapper;
import cn.microservice.www.model.Permission;
import cn.microservice.www.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 权限服务实现类
 * @author MachineGeek
 */
@DubboService(version = "1.0.0")
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}

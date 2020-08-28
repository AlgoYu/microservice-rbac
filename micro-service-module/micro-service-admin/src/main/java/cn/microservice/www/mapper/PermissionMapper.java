package cn.microservice.www.mapper;

import cn.microservice.www.model.Account;
import cn.microservice.www.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限映射类
 * @author MachineGeek
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}

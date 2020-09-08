package cn.microservice.www.mapper;

import cn.microservice.www.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限映射类
 * @author MachineGeek
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectPermissionsByRoleId(@Param(value = "roleId") Long roleId);
}

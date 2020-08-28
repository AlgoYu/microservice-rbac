package cn.microservice.www.mapper;

import cn.microservice.www.model.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 账户映射类
 * @author MachineGeek
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}

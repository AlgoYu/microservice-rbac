package cn.microservice.www.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus配置
 * @author MachineGeek
 */
@Configuration
public class MyBatisPlusConfig {
    /**
     * 开启乐观锁
     * @return
     */
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}

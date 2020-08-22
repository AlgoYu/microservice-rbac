package cn.microservice.www.config;

import cn.microservice.www.tool.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ID生成器
 * @author MachineGeek
 */
@Configuration
public class SnowFlakeConfig {
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1,1);
    }
}

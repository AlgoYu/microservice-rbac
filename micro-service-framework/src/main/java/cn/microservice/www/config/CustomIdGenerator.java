package cn.microservice.www.config;

import cn.microservice.www.tool.IdWorker;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ID生成器
 * @author MachineGeek
 */
@Slf4j
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Autowired
    private IdWorker idWorker;
    @Override
    public Number nextId(Object entity) {
        return idWorker.nextId();
    }
}

package cn.microservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 角色启动类
 * @author MachineGeek
 */
@SpringBootApplication
@EnableOpenApi
public class RoleMain {
    public static void main(String[] args) {
        SpringApplication.run(RoleMain.class,args);
    }
}

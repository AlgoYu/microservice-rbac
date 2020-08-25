package cn.microservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 权限服务启动类
 * @author MachineGeek
 */
@SpringBootApplication
@EnableOpenApi
public class PermissionMain {
    public static void main(String[] args) {
        SpringApplication.run(PermissionMain.class,args);
    }
}

package cn.microservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 权限服务启动类
 * @author MachineGeek
 */
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
public class PermissionMain {
    public static void main(String[] args) {
        SpringApplication.run(PermissionMain.class,args);
    }
}

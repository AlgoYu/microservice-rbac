package cn.microservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 角色启动类
 * @author MachineGeek
 */
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
public class RoleMain {
    public static void main(String[] args) {
        SpringApplication.run(RoleMain.class,args);
    }
}

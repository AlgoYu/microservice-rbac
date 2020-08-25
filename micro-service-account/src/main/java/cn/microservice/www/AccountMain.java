package cn.microservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 账户服务启动类
 * @author MachineGeek
 */
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
public class AccountMain {
    public static void main(String[] args) {
        SpringApplication.run(AccountMain.class,args);
    }
}

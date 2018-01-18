package cn.tac.test.spring.cloud.client.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tac
 * @since 16/01/2018
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableDiscoveryClient(autoRegister = false)  //禁止注册到服务注册中心
public class SimpleClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleClientApplication.class, args);
    }
}

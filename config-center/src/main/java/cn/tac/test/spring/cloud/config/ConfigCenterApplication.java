package cn.tac.test.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author tac
 * @since 16/01/2018
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigCenterApplication {
    public static void main(String[] args) {
        //启动后访问http://tac.config.com:{port}/master/helloworld-dev.yml可以查看到示例的配置文件
        SpringApplication.run(ConfigCenterApplication.class, args);
    }
}

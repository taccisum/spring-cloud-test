package cn.tac.test.spring.cloud.eureka.peer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tac
 * @since 19/01/2018
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaPeer1Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPeer1Application.class, args);
    }
}

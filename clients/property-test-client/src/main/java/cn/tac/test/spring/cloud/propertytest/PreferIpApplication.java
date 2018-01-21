package cn.tac.test.spring.cloud.propertytest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author tac
 * @since 21/01/2018
 */
@SpringBootApplication
public class PreferIpApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .profiles("prefer-ip")
                .sources(PreferIpApplication.class)
                .run(args);
    }
}

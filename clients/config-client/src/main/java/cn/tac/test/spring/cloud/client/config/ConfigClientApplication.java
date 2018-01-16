package cn.tac.test.spring.cloud.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tac
 * @since 16/01/2018
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @GetMapping("env")
    public String test() {
        return environment.toString();
    }

    @GetMapping("author")
    public String author() {
        return environment.getProperty("author");
    }

    @GetMapping("greeting")
    public String greeting() {
        return environment.getProperty("greeting");
    }
}

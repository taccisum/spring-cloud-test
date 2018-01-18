package cn.tac.test.spring.cloud.client.config.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tac
 * @since 18/01/2018
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class DiscoveryConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryConfigClientApplication.class, args);
    }

    @Autowired
    private Environment environment;

    @GetMapping("greeting")
    public String greeting(){
        return environment.getProperty("greeting");
    }
}

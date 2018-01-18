package cn.tac.test.spring.cloud.client.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tac
 * @since 16/01/2018
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
@RestController
public class ManualApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManualApplication.class, args);
    }

    @Autowired
    private ServiceRegistry registry;

    @GetMapping("register")
    public String register() {
        //手动注册
//        Registration registration = constructRegistration();
//        this.registry.register(registration);
        return "注册成功";
    }
}

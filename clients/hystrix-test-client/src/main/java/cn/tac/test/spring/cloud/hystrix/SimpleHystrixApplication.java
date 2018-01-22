package cn.tac.test.spring.cloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author tac
 * @since 22/01/2018
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient(autoRegister = false)
public class SimpleHystrixApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(false)
                .sources(SimpleHystrixApplication.class)
                .run(args);
    }

    private static int i = 0;

    @Service
    class FooService {
        @HystrixCommand(fallbackMethod = "barFallback")
        public String bar() {
            if (i < 10) {
                i++;
                return "123";
            } else {
                throw new RuntimeException();
            }
        }

        public String barFallback() {
            return "error";
        }
    }

    @Component
    class OnStartBean implements InitializingBean {
        @Autowired
        private FooService service;

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("----------begin test----------");
            for (int i = 0; i < 20; i++) {
                System.out.println(service.bar());
            }
            System.out.println("----------end test----------");
        }
    }
}

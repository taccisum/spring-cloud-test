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

    private static int successCount = 0;
    private static int errorCount = 0;
    private static int fallbackCount = 0;

    @Service
    class FooService {
        @HystrixCommand(fallbackMethod = "barFallback")
        public void bar() {
            if (successCount < 10) {
                successCount++;
            } else {
                // 调用失败次数达到阈值将开启熔断器，所有的请求直接fast-fail，不会再执行到此处
                // 熔断时间窗后熔断器会调整为半开状态，此时允许一个请求通过，如果该请求还是失败，则重新回到开启状态
                errorCount++;
                throw new RuntimeException();
            }
        }

        public void barFallback() {
            fallbackCount++;
        }
    }

    @Component
    class OnStartBean implements InitializingBean {
        @Autowired
        private FooService service;

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("----------begin test----------");
            for (int i = 0; i < 10000; i++) {
                service.bar();
            }

            System.out.println("success count: " + successCount);
            System.out.println("error count: " + errorCount);
            System.out.println("fallback count: " + fallbackCount);
            System.out.println("----------end test----------");
        }
    }
}

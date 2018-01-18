package cn.tac.test.spring.cloud.client.using;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tac
 * @since 19/01/2018
 */
@SpringBootApplication
@RestController
public class UsingClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsingClientApplication.class, args);
    }

    @Autowired
    private EurekaClient discoveryClient;

    /**
     * /serviceUrl?appName=simple-client
     * @param appName 已经注册到Eureka的服务实例id
     */
    @GetMapping("serviceUrl")
    public String serviceUrl(@RequestParam("appName") String appName){
        try {
            InstanceInfo instance = discoveryClient.getNextServerFromEureka(appName, false);
            return instance.getHomePageUrl();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

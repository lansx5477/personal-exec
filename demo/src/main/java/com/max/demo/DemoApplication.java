package com.max.demo;

import com.customer.starter.service.CustomService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xiaoyinglan
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        for (String s : context.getBeanNamesForType(CustomService.class)) {
            System.out.println(s);
        }
    }

}

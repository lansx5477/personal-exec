package com.customer.starter.auto;

import com.customer.starter.properties.CustomServiceProperties;
import com.customer.starter.service.CustomService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Project custom-starter
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/15:47
 * @Description:
 * @Version 1.0
 */
@AutoConfiguration
@ConditionalOnMissingBean(CustomService.class)
@EnableConfigurationProperties(CustomServiceProperties.class)
@ConditionalOnProperty(prefix = "custom.service", name = "enabled", havingValue = "true")
public class CustomServiceAutoConfiguration {
    @Bean
    public CustomService customService() {
        return new CustomService();
    }
}

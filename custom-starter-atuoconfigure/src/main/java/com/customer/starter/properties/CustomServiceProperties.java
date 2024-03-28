package com.customer.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Project custom-starter
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/15:48
 * @Description:
 * @Version 1.0
 */
@ConfigurationProperties("custom.service")
@Data
public class CustomServiceProperties {

    private boolean enabled = false;

    private String prefix = "prefix";

    private String suffix = "suffix";
}

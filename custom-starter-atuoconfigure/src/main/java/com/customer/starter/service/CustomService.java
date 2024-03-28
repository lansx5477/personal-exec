package com.customer.starter.service;

import com.customer.starter.properties.CustomServiceProperties;
import jakarta.annotation.Resource;
import org.slf4j.helpers.MessageFormatter;

/**
 * @Project custom-starter
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/15:48
 * @Description:
 * @Version 1.0
 */
public class CustomService {
    @Resource
    private CustomServiceProperties properties;

    public String plain(String title) {
        return MessageFormatter.format(title + ":{}->{}", properties.getPrefix(), properties.getSuffix()).getMessage();
    }
}

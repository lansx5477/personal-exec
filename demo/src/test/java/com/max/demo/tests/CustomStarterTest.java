package com.max.demo.tests;

import com.customer.starter.service.CustomService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/17:25
 * @Description: 自定义starter测试
 * @Version 1.0
 */
@SpringBootTest
public class CustomStarterTest {
    @Resource
    private CustomService customService;

    @Test
    @DisplayName("测试自定义starter")
    void test() {
        System.out.println(customService.plain("测试自定义starter"));;
    }
}

package com.max.demo.tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/02/16:47
 * @Description:
 * @Version 1.0
 */
@DisplayName(("Junit5学习"))
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Junit5Test {

    @DisplayName("测试DisplayName注解")
    @Test
    public void testDisplay() {
        log.info("testDisplay");
    }

    @ParameterizedTest
    @DisplayName("参数化测试方法")
    @ValueSource(strings = { "a", "b", "b" })
    @Disabled
    public void palindromes(String candidate) {
        Assert.isTrue(StringUtils.isNotEmpty(candidate) && (candidate.toCharArray().length <= 1), "error");
    }

    @RepeatedTest(value = 5, failureThreshold = 1, name = "cs")
    @DisplayName("repeatTest")
    @Test
    public void repeatTest() {
        System.out.println("repeat!");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    @Disabled
    public void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }


    @BeforeEach
    // @Test
    void beforeEach() {
        log.info("===单元测试执行之前===");
    }


    @AfterEach
    // @Test
    void afterEach() {
        log.info("===单元测试执行之后===");
    }

    @BeforeAll
    // @Test
    void beforeAll() {
        log.info("===所有的单元测试执行之前===");
        log.info("===复杂资源的初始化===");
    }

    @AfterAll
    void afterAll() {
        log.info("====实例级别资源的清理===");
    }
}

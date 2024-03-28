package com.max.demo.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/10:33
 * @Description: 断言测试
 * @Version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class AssertionTest {

    @Test
    @DisplayName("assertion test")
    void sample() {
        assertEquals(3, 1+2, "math error");
        Integer integer1 = Integer.valueOf(10);
        Integer integer2 = Integer.valueOf(10);
        assertSame(integer1, integer2, "integer 10 指针指向同一个对象");
        // assertSame(Integer.valueOf(155), Integer.valueOf(155), "integer 155 指针指向同一个对象");
        assertNotSame(Integer.valueOf(155), Integer.valueOf(155), "integer 155 指针指向不同对象");
        assertAll("异常头部信息", () -> assertEquals(3, 1 + 2), () -> assertTrue(1 > 0));
    }

    @Test
    @DisplayName("exception assert test")
    void exceptionTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> System.out.println(1 % 0));
        System.out.println(exception);
    }

}

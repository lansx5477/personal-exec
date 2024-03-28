package com.max.demo.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/11:46
 * @Description: 前置条件测试
 * @Version 1.0
 */
@DisplayName("preconditions")
@Slf4j
public class AssumptionTest {

    private static final String ENV = "dev";

    @Test
    @DisplayName("assumption test")
    void assumption() {
        Assumptions.assumeFalse(() -> Objects.equals(ENV, "prod"));
        log.info("***");
        Assumptions.assumeTrue(() -> Objects.equals(Integer.valueOf(10), Integer.valueOf(10)));
        Assumptions.assumingThat(Objects.equals(ENV, "dev"), () -> System.out.println("ENV=DEV"));
        log.info("---");
        Assumptions.assumingThat(1 > 0, () -> System.out.println("ENV=DEV"));
        log.info("...");
    }
}

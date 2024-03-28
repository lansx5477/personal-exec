package com.max.demo.grammar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/03/13/15:00
 * @Description:
 * @Version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StreamTest {

    @Test
    @DisplayName("optional test")
    public void optional() {
        List<String> list = null;
        // List<String> list = Arrays.asList("optional1", null, "optional2");
        List<String> collect = Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .filter(actionInfo -> actionInfo != null)
                .sorted(Comparator.nullsLast(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(collect.size());
        collect.forEach(System.out::println);
    }
}

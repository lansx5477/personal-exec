package com.max.demo.errors;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/02/15:14
 * @Description: 用于测试 @ResponseStatus 注解的异常
 * @Version 1.0
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad req")
@NoArgsConstructor
public class TestResponseStatusException extends RuntimeException {
}

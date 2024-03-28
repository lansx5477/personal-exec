package com.max.demo.controller;

import com.max.demo.errors.TestResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/02/15:16
 * @Description:
 * @Version 1.0
 */
@RestController
public class ErrorController {

    @GetMapping("/test/response/status")
    public String testResponseStatus() {
        throw new TestResponseStatusException();
    }
}

package com.max.demo.controller;

import com.max.demo.pojo.Computer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/31/15:45
 * @Description:
 * @Version 1.0
 */
@Controller
public class CustomProtocolController {

    @PostMapping(value = "/custom/message/converter")
    @ResponseBody
    public Computer testCustomMessageConverter(Computer computer) {
        return computer;
    }
}

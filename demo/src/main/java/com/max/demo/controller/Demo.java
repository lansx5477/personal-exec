package com.max.demo.controller;

import com.customer.starter.service.CustomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.demo.pojo.Computer;
import com.max.demo.pojo.FileUploadReq;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/04/15:54
 * @Description:
 * @Version 1.0
 */
@Controller
public class Demo {
    @Value("${test.var1:B}")
    private String var1 = "C";

    @Value("${test.var2:B}")
    private String var2 = "C";

    @Value("${test.var3}")
    private String var3 = "D";

    // @Resource
    // private CustomService customService;

    // @RequestMapping("/cs")
    public String index() {
        System.out.println("---");
        return "/index.html";
    }

    @DeleteMapping ("/usr")
    @ResponseBody
    public String deleteMethodTest() {
        return "delete";
    }

    @GetMapping("/usr")
    @ResponseBody
    public String getMethodTest(Model model) {
        model.addAttribute("md1", UUID.randomUUID().toString());
        return "var1=" + var1 + " var2=" + var2 + " var3=" + var3;
    }

    @GetMapping("/test/model/v1")
    public String testModel(Model model) {
        model.addAttribute("md1", UUID.randomUUID().toString());
        return "forward:/test/model/v2";
    }

    @GetMapping("/test/model/v2")
    @ResponseBody
    public String testModel2(HttpServletRequest request) {
        return (String) request.getAttribute("md1");
    }

    @PostMapping(value = "/test/custom/obj", params = "!special")
    @ResponseBody
    public Computer testCustomObj(Computer computer) {
        return computer;
    }

    @PostMapping(value = "/test/custom/obj", params = "special")
    @ResponseBody
    public String testCustomObj2(String special) {
        return special;
    }


    @PostMapping(value = "/test/error/handle")
    @ResponseBody
    public String testError() {
        throw new ArithmeticException("test");
    }

    @PostMapping(value = "/test/reproduction")
    public String bugReproduction() throws Exception {
        byte[] bytes = new byte[1];
        bytes[0] = 1;
        MockMultipartFile mockMultipartFile = new MockMultipartFile("fileName.png", "fileName.png", null, bytes);
        FileUploadReq fileUploadReq = FileUploadReq.builder()
                .appId("123456")
                .businessCode("123456")
                .fileUploadForm(mockMultipartFile).build();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(fileUploadReq);
    }
}

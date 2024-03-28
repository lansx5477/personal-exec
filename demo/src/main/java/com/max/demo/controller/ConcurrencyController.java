package com.max.demo.controller;

import com.max.demo.pojo.Computer;
import com.max.demo.utils.ForTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Objects;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/22/17:29
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class ConcurrencyController {

    private static final SecureRandom secureRandom = new SecureRandom();
    private Computer computer;

    @RequestMapping("/concurrency")
    private void test() {
        Computer computer1 = new Computer();
        computer1.setCpu("first");
        int randomNum = secureRandom.nextInt(128);
        assembleParam(computer1, randomNum);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void assembleParam(Computer computer1, Integer flag) {
        String c1 = computer1.getCpu();
        computer = ForTest.updateComputer(computer1, flag);
        computer1.setCpu(computer.getCpu());
        String c2 = computer1.getCpu();
        if (flag % 2 == 1 && !Objects.equals(c1, c2)) {
            System.out.println(Thread.currentThread().getName() + " " + "origin:" + c1 + "==>" + computer1 + "---" + flag);
        }
    }
}

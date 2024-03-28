package com.max.demo.utils;

import com.max.demo.pojo.Computer;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/22/17:31
 * @Description:
 * @Version 1.0
 */
public class ForTest {
    private static final Integer TWO = 2;

    public static Computer updateComputer(Computer computer1, Integer flag) {
        Computer computer = new Computer();
        if (flag % TWO == 0) {
            computer.setCpu("天机9300-" + flag);
        } else {
            computer.setCpu(computer1.getCpu());
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return computer;
    }
}

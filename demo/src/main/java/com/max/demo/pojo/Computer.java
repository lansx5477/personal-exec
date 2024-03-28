package com.max.demo.pojo;

import com.max.demo.annotations.SpecialData;
import lombok.Data;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/22/17:42
 * @Description:
 * @Version 1.0
 */
@Data
@SpecialData
public class Computer {

    private String cpu;

    private String gpu;

    private Integer price;
}

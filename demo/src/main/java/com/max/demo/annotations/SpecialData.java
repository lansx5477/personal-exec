package com.max.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/31/14:46
 * @Description: 将数据写成特定格式
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpecialData {
}

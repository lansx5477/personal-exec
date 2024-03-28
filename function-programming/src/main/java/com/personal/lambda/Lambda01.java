package com.personal.lambda;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Project personal_exec
 * @Author: xiaoyinglan
 * @Date: 2023/12/13/17:02
 * @Description:
 * @Version 1.0
 */
public class Lambda01 {

    private static void test01() {
        new Thread(() -> System.out.println("thread1")).start();
        new Thread(() -> {for (int i = 0; i < 100; i++) {
            System.out.println("t1" + "-" + i);
        }}).start();
        new Thread(() -> {for (int i = 0; i < 100; i++) {
            System.out.println("t2" + "-" + i);
        }}).start();
    }

    private static void test02() {
        JButton button = new JButton("show");
        button.addActionListener(e -> System.out.println("按钮点击"));
    }

    private static void test03() {
        int[] arr = {1, 3, 4, 5, 5, 65, 67, 78, 98};
        List<Integer> collect = Arrays.stream(arr).mapToObj(Integer::new).collect(Collectors.toList());
        collect.forEach(num -> System.out.print(num + " "));
    }

    public static void main(String[] args) {
        test03();
    }

}

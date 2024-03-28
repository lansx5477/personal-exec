package com.max.demo.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest {

    @Test
    @Order(6)
    void testOuter1() {
        System.out.println("Executing testOuter1");
    }

    @Test
    @Order(7)
    void testOuter2() {
        System.out.println("Executing testOuter2");
    }

    @Nested
    @TestMethodOrder(OrderAnnotation.class)
    @Order(3)
    class InnerClass {

        @Test
        @Order(1)
        void testInner1() {
            System.out.println("InnerClass Executing testInner1");
        }

        @Test
        @Order(4)
        void testInner2() {
            System.out.println("InnerClass Executing testInner2");
        }
    }

    @Test
    @Order(8)
    void testOuter3() {
        System.out.println("Executing testOuter3");
    }

    @Test
    @BeforeEach
    void testOuter5() {
        System.out.println("before each 2");
    }


    @BeforeEach
    void testOuter4() {
        System.out.println("before each 1 ");
    }
}

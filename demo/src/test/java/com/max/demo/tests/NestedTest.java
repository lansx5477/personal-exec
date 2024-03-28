package com.max.demo.tests;

import org.junit.jupiter.api.*;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/02/04/13:59
 * @Description: 嵌套测试
 * @Version 1.0
 */
@DisplayName("A stack")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NestedTest {
    Stack<Object> stack;

    @Nested
    @DisplayName("when new")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class WhenNew {

        @BeforeAll
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            Assertions.assertTrue(stack == null || stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            Assertions.assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            Assertions.assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class AfterPushing {
            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            @Order(1)
            void isNotEmpty() {
                Assertions.assertFalse(stack == null || stack.isEmpty());
                Assertions.assertEquals(anElement, stack.pop());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            @Order(2)
            void returnElementWhenPopped() {
                Assertions.assertEquals(anElement, stack.pop());
                Assertions.assertTrue(stack == null || stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            @Order(3)
            void returnElementWhenPeeked() {
                Assertions.assertEquals(anElement, stack.peek());
                Assertions.assertFalse(stack.isEmpty());
                // Assertions.assertEquals(anElement, stack.pop());
            }
        }
    }
}

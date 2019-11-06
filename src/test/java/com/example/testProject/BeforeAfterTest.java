package com.example.testProject;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("before each");
    }

    @AfterAll
    static void setupAfterAll() {
        System.out.println("after all");
    }

    @AfterEach
    void setupAfterEach() {
        System.out.println("after each");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }
}
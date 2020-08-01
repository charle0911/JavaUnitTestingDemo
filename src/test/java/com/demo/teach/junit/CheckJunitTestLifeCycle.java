package com.demo.teach.junit;

import java.util.concurrent.TimeUnit;

import org.junit.*;

public class CheckJunitTestLifeCycle {

    @BeforeClass
    public static void checkBeforeClass() {
        System.out.println("I'm before class");
    }

    @Before
    public void checkBefore() {
        System.out.println("I'm before method");
    }

    @Test
    public void doSomething() {
        System.out.println("Hi I'm test One");
    }

    @Test
    public void doSomethingTwo() {
        System.out.println("Hi I'm test Two");
    }

    @Ignore
    public void wontRun() {
        System.out.println("Hi I won't run");
    }

    @Test(timeout = 5000)
    public void checkTimeout() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        System.out.println("Check time out");
    }

    @Test(expected = RuntimeException.class)
    public void checkException() {
        throw new RuntimeException();
    }

    @After
    public void cleanMethod() {
        System.out.println("Clean method");
    }

    @AfterClass
    public static void cleanClass() {
        System.out.println("Clean class");
    }

}

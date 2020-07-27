package com.demo.teach.mock;


import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestDouble {

    TestClass sut = new TestClass();

    @Test
    public void originalClass() {
        TestInterface testInterface = new TestInnerClass();
        sut.setInnerClass(testInterface);
        sut.run();
    }

    @Test
    public void checkMock() {
        TestInterface testInterface = mock(TestInnerClass.class);
        sut.setInnerClass(testInterface);

        doReturn("Mock class ").when(testInterface).doSomething();

        sut.run();

    }

    @Test
    public void checkSpy() {
        TestInterface testInterface = spy(new TestInnerClass());
        sut.setInnerClass(testInterface);

        doReturn("Mock class ").when(testInterface).doSomething();

        sut.run();
    }


    interface TestInterface {
        String doSomething();
        String doSomethingTwo();
    }

    class TestInnerClass implements TestInterface {

        @Override
        public String doSomething() {
            return "In inner class's method one";
        }

        @Override
        public String doSomethingTwo() {
            return "In inner class's method two";
        }
    }

    class TestClass {

        private TestInterface innerClass;

        public void setInnerClass(TestInterface innerClass) {
            this.innerClass = innerClass;
        }

        public void run() {
            System.out.println(innerClass.doSomething() + "call by test class");
            System.out.println(innerClass.doSomethingTwo() + "call by test class");
        }
    }
}

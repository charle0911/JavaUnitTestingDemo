package com.demo.teach.mock.component;

public class SystemUnderTest {
    private DependedOnComponent dependedOnComponent;

    public void setDependedOnComponent(DependedOnComponent dependedOnComponent) {
        this.dependedOnComponent = dependedOnComponent;
    }

    public void run() {
        System.out.println(dependedOnComponent.doSomething() + "call by test class");
        System.out.println(dependedOnComponent.doSomethingTwo() + "call by test class");
    }
}

package com.demo.teach.mock;


import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.demo.teach.mock.component.DependedOnComponent;
import com.demo.teach.mock.component.SystemUnderTest;

public class TestMock {

    SystemUnderTest sut = new SystemUnderTest();

    @Test
    public void originalClass() {
        DependedOnComponent testInterface = new DependedOnComponent();
        sut.setDependedOnComponent(testInterface);
        sut.run();
    }

    @Test
    public void testSutByMock() {
        DependedOnComponent dependedOnComponent = Mockito.mock(DependedOnComponent.class);
        sut.setDependedOnComponent(dependedOnComponent);

        Mockito.when(dependedOnComponent.doSomething()).thenReturn("Mock class");
        sut.run();
    }

}

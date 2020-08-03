package com.demo.teach.junit4;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;

class TestObject {
    TestObject(String type, int cnt) {
        this.type = type;
        this.cnt = cnt;
    }

    String type;
    int cnt;
}

public class CheckByAssertJ {

    static List<TestObject> testList;

    @BeforeClass
    public static void setList() {
        testList = Arrays.asList(new TestObject("A", 1),
                new TestObject("B", 1),
                new TestObject("C", 1),
                new TestObject("D", 1),
                new TestObject("E", 1));

    }

}

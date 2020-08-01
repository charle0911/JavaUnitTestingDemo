package com.demo.teach.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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

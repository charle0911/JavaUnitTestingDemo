package com.demo.teach.junit;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckParameterized {

    private int testNumber;

    public CheckParameterized(Integer testNumber) {
        this.testNumber = testNumber;
    }

    @Parameterized.Parameters
    public static List<Integer> testData() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    public void testCase() {
        System.out.println(testNumber);
    }
}

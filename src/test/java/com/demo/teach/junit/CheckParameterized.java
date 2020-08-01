package com.demo.teach.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckParameterized {

    private int testNumber;
    private boolean result;

    private StateMachine stateMachine = new StateMachine();

    public CheckParameterized(Integer testNumber, Boolean result) {
        this.testNumber = testNumber;
        this.result = result;
    }

    @Parameterized.Parameters
    public static List<Object> testData() {
        return Arrays.asList(
                new Object[][]{
                        {0, true},
                        {1, false},
                        {2, false},
                        {3, true}
                }
        );
    }

    @Test
    public void testCase() {
        assertEquals(stateMachine.checkNumber(testNumber), result);
    }

    class StateMachine {
        public boolean checkNumber(int input) {
            return input % 3 == 0;
        }
    }
}

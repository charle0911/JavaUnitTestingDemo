package com.demo.teach.junit;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class CheckAssert {

    String t1 = "t1";
    int i1 = 1;
    boolean b1 = true;
    int[] ia = new int[]{1,2,3};
    List<Integer> il = Arrays.asList(1,2,3,4,5);

    @Test
    public void testT1Equal() {
        Assert.assertEquals(t1, "t1");
    }

    @Test
    public void testI1Equal() {
        Assert.assertEquals(i1, 1);
    }

    @Test
    public void testB1() {
        Assert.assertTrue(b1);
        Assert.assertNotEquals(b1, true);
    }

    @Test
    public void testIA() {
        Assert.assertArrayEquals(ia, new int[]{1,2,3});
    }

    @Test
    public void testIL() {
        //It call by reference
        Assert.assertNotSame(il, Arrays.asList(1,2,3,4,5));

        //It call by value
        Assert.assertEquals(il, Arrays.asList(1,2,3,4,5));
    }
}

package com.yao.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTest {

    Integer[] array;

    @Before
    public void setUp() throws Exception {
        array = ArrayUtils.init(10);
        Assert.assertTrue(array.length == 10);
    }

    @Test
    public void print() {
        ArrayUtils.print(array);
    }

    @Test
    public void swap() {
        final Integer val0 = array[0];
        final Integer val9 = array[9];
        ArrayUtils.swap(array, 0, 9);

        Assert.assertTrue(array[9] == val0 && array[0] == val9);
    }

    @Test
    public void sort() {
        final Integer[] tmpArr = ArrayUtils.sort(array);
        for (int i = 0; i < tmpArr.length - 1; i++) {
            Assert.assertTrue(tmpArr[i] <= tmpArr[i + 1]);
        }
        ArrayUtils.print(array);
        ArrayUtils.print(tmpArr);
    }
}
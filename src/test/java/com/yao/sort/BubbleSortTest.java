package com.yao.sort;


import com.yao.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    private final int ARR_LEN = 100;

    private Integer[] array;


    @Before
    public void init() {
        array = ArrayUtils.init(ARR_LEN);
    }

    @Test
    public void test() {
        ArrayUtils.print(array);
        final Integer[] sort = BubbleSort.sort(Arrays.copyOf(array, array.length));
        ArrayUtils.print(sort);
        Assert.assertTrue(Arrays.equals(sort, ArrayUtils.sort(array)));
    }
}
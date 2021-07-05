package com.yao.sort;

import com.yao.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SelectionSortTest {

    private Integer[] array;


    @Before
    public void setUp() throws Exception {
        array = ArrayUtils.init(100);
    }

    @Test
    public void sort() {
        ArrayUtils.print(array);
        final Integer[] sort = SelectionSort.sort(Arrays.copyOf(array, array.length));
        ArrayUtils.print(sort);
        Assert.assertTrue(Arrays.equals(sort, ArrayUtils.sort(array)));
    }
}
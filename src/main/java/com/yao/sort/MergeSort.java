package com.yao.sort;

import java.util.Arrays;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230557043-37375010.gif">
 * 合并排序
 * </a></b>
 * <pre><b>描述：</b>拆分（有终点）+ 重新合并</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <ul>
 *     <li>时间复杂度<pre>n*log2(n)</pre></li>
 *     <li>空间复杂度<pre>n</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/24
 */
public final class MergeSort {

    private static final int SLICE_LIMIT = 2;

    public static Integer[] sort(Integer[] array) {

        return slice(array);
    }

    private static Integer[] slice(Integer[] array) {

        final int length = array.length;
        if (length < SLICE_LIMIT) {
            return array;
        }

        int midIdx = length / 2;
        return merge(
                slice(Arrays.copyOfRange(array, 0, midIdx)),
                slice(Arrays.copyOfRange(array, midIdx, length)));
    }

    private static Integer[] merge(Integer[] left, Integer[] right) {

        final int length = left.length + right.length;
        final Integer[] array = new Integer[length];

        int idx = 0, leftIdx = 0, rightIdx = 0;
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                array[idx++] = left[leftIdx++];
            } else {
                array[idx++] = right[rightIdx++];
            }
        }

        while (leftIdx < left.length) {
            array[idx++] = left[leftIdx++];
        }
        while (rightIdx < right.length) {
            array[idx++] = right[rightIdx++];
        }

        return array;
    }
}

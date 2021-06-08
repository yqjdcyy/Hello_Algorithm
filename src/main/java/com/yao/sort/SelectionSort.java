package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif">
 * 选择排序
 * </a></b>
 * <pre>演示地址：<a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <pre>描述：先比（选择）后换</pre>
 * <ul>
 *     <li>时间复杂度<pre>n^2</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>不稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/24
 */
public final class SelectionSort {


    public static Integer[] sort(Integer[] array) {

        final int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[idx]) {
                    idx = j;
                }
            }
            if (i != idx) {
                ArrayUtils.swap(array, i, idx);
            }
        }

        return array;
    }
}

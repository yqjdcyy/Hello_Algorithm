package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif">
 * 选择排序
 * </a></b>
 * <pre><b>描述：</b>冒泡的逆向版本，遍历选择当前最小值后，与起始位置交换</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
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
            for (int j = i + 1; j <= length - 1; j++) {

                if (array[j] < array[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                ArrayUtils.swap(array, i, idx);
            }
        }

        return array;
    }
}

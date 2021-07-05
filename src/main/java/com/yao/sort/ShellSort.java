package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif">
 * 希尔排序
 * </a></b>
 * <pre><b>描述：</b>插入排序进阶版本；涨幅由1调整为阶梯形式 /2 /4/ /8..</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <ul>
 *     <li>时间复杂度<pre>n^1.3</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>不稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/24
 * @Desc
 */
public final class ShellSort {

    private static final int GAP_SIZE = 2;

    public static Integer[] sort(Integer[] array) {

        final int length = array.length;

        for (int gap = length / GAP_SIZE; gap > 0; gap /= GAP_SIZE) {

            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < length; j += gap) {
                    int index = j - gap;
                    int value = array[j];
                    while (index >= 0 && array[index] >= value) {
                        array[index + gap] = array[index];
                        index -= gap;
                    }
                    array[index + gap] = value;
                }
            }
        }

        return array;
    }
}

package com.yao.sort;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif">
 * 希尔排序
 * </a></b>
 * <pre>插入排序进阶版本</pre>
 * <pre>演示地址：<a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
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
            for (int i = gap; i < length; i++) {
                int index = i - gap;
                int value = array[i];
                while (index >= 0 && array[index] >= value) {
                    array[index + gap] = array[index];
                    index -= gap;
                }
                array[index + gap] = value;
            }
        }

        return array;
    }
}

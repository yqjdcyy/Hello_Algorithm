package com.yao.sort;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015223238449-2146169197.gif">
 * 冒泡排序
 * </a></b>
 * <pre><b>描述：</b>从最低位开始，逐一比较后将最大元素（泡）置于顶层（冒）</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <pre>演示地址：<a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <pre>描述：最大往上比较，最大的气泡最先置顶</pre>
 * <ul>
 *     <li>时间复杂度<pre>n^2</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/24
 */
public class BubbleSort {

    public static Integer[] sort(Integer[] array) {

        final int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    Integer tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        return array;
    }
}

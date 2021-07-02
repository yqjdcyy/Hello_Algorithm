package com.yao.sort;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015225645277-1151100000.gif">
 * 插入排序
 * </a></b>
 * <pre><b>描述：</b>向后遍历时，将当前值与前面的值逐一比较（类似插入扑克牌，小则将对比值后移，直到底或更小值时交换位置）</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <ul>
 *     <li>时间复杂度<pre>n^2</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/24
 */
public final class InsertSort {

    public static Integer[] sort(Integer[] array) {

        final int length = array.length;

        for (int i = 1; i < length; i++) {
            int index = i - 1;
            int value = array[i];
            while (index >= 0 && array[index] >= value) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = value;
        }
        return array;
    }
}

package com.yao.sort;

import com.yao.utils.ArrayUtils;

import java.util.Arrays;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231740840-6968181.gif">
 * 计数排序
 * </a></b>
 * <pre>演示地址：<a href="https://www.cs.usfca.edu/~galles/visualization/CountingSort.html">Counting Sort</a></pre>
 * <pre>适用场景：内容不多，数据集中场景</pre>
 * <ul>
 *     <li>时间复杂度<pre>n+k</pre></li>
 *     <li>空间复杂度<pre>k</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/26
 */
public final class CountingSort {

    public static Integer[] sort(Integer[] array) {

        final int length = array.length;
        Integer[] limits = ArrayUtils.limit(array);
        int min = limits[0];
        int max = limits[1];
        Integer[] counter = new Integer[max - min + 1];
        Arrays.fill(counter, 0);

        // O(n)
        // 对应数值位+1
        for (int i = 0; i < length; i++) {
            counter[array[i] - min]++;
        }

        // O(n+K)
        for (int i = 0, arrIdx = 0; i < length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                array[arrIdx++] = i + min;
            }
        }

        return array;
    }
}

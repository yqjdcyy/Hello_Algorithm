package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231308699-356134237.gif">
 * 堆排序
 * </a></b>
 * <pre>演示地址：<a href="https://www.cs.usfca.edu/~galles/visualization/HeapSort.html">Heap Sort</a></pre>
 * <ul>
 *     <li>时间复杂度<pre>n*log2(n)</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>不稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/26
 */
public final class HeapSort {

    private static final int HEAP_LEVEL = 2;


    public static Integer[] sort(Integer[] array) {

        int length = array.length;
        // Error-3：整体大堆排序
        for (int i = length / HEAP_LEVEL; i >= 0; i--) {
            heapify(array, i, length);
        }
        // O(n)
        // Error-4：交换后重新大堆排序
        for (int i = length - 1; i > 0; i--) {
            ArrayUtils.swap(array, 0, i);
            // O(log2(n))
            heapify(array, 0, i);
        }

        return array;
    }

    private static void heapify(Integer[] array, int p, int length) {

        // Error-2: 叶节点获取错误
        final int left = 2 * p + 1;
        final int right = 2 * p + 2;
        int max = p;

        // Error-1：左右叶子比较后，替换大者即可；而非原来的左右均进行比较
        if (left < length && array[left] > array[p]) {
            max = left;
        }
        if (right < length && array[right] > array[p] && array[right] > array[max]) {
            max = right;
        }

        if (max != p) {
            ArrayUtils.swap(array, max, p);
            heapify(array, max, length);
        }
    }
}

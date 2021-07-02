package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230936371-1413523412.gif">
 * 快速排序
 * </a></b>
 * <pre><b>描述：</b>以起始点为标尺，从右到左找小值、从左到右找大值，重复至两者重叠；后按基准点与左队极限交换后，左右队列分治处理（基准点左右队列分别全小、大于它）</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Comparison Sorting Algorithms</a></pre>
 * <pre><b>教程示例：</b><a href="https://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html">快速排序</a></pre>
 * <ul>
 *     <li>时间复杂度<pre>n*log2(n)</pre></li>
 *     <li>空间复杂度<pre>1</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/25
 */
public final class QuickSort {

    public static Integer[] sort(Integer[] array) {

        sort0(array, 0, array.length - 1);
        return array;
    }

    private static void sort0(Integer[] array, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int base = array[start];
        int left = start;
        // O(N)
        // 先右找小，后左找大，重叠时退出（作为与基准点的交换位置），否则两者交换
        for (int right = end; left < right; ) {
            while (array[right] >= base && left < right) {
                right--;
            }
            while (array[left] <= base && left < right) {
                left++;
            }
            if (left != right) {
                ArrayUtils.swap(array, left, right);
            }
        }
        ArrayUtils.swap(array, start, left);
        ArrayUtils.print(array);

        // O(logN)
        // 以重叠点为界（不包含），左右侧数组递归排序
        sort0(array, start, left - 1);
        sort0(array, left + 1, end);
    }
}

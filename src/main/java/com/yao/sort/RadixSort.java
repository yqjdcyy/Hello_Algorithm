package com.yao.sort;

import com.yao.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015232453668-1397662527.gif">
 * 基数排序
 * </a></b>
 * <pre><b>描述：</b>将数据补全至一样的长度后，从低位到高位依次将数据置入对应的数组中（此时为个数）；后按数据、置入顺序取出，向左移位（十位）后，重复操作至最后一位</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/RadixSort.html">Radix Sort</a></pre>
 * <pre><b>适用场景：</b>数量远大于十的整数场景</pre>
 * <ul>
 *     <li>时间复杂度<pre>n*k</pre></li>
 *     <li>空间复杂度<pre>n+k</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 *
 * @author qingju.yao
 * @date 2020/06/26
 */
public final class RadixSort {

    private static final int SCALE = 10;

    public static Integer[] sort(Integer[] array) {

        final int round = ArrayUtils.limit(array)[1].toString().length();
        final List[] listArr = new List[SCALE];
        for (int i = 0; i < SCALE; i++) {
            listArr[i] = new ArrayList();
        }

        // O(k* 3n)= O(n* k)
        for (int i = 0; i < round; i++) {

            // fill
            int pow = (int) Math.pow(SCALE, i);
            for (int j = 0; j < array.length; j++) {
                Integer value = array[j];
                int idx = value / pow % SCALE;
                listArr[idx].add(value);
            }

            // read
            for (int j = 0, idx = 0; j < listArr.length; j++) {
                Iterator iterator = listArr[j].iterator();
                while (iterator.hasNext()) {
                    array[idx++] = (Integer) iterator.next();
                }
                listArr[j].clear();
            }
        }

        return array;
    }
}

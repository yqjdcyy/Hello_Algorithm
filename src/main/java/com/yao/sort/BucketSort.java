package com.yao.sort;

import com.yao.utils.ArrayUtils;

/**
 * <b><a href="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015232107090-1920702011.png">
 * 桶排序
 * </a></b>
 * <pre><b>描述：</b>通过最大、小值界定有限的桶（每个桶各有数值范围)，并依次将数据按范围、桶内值顺序插入；最后按桶、桶内顺序依次读取</pre>
 * <pre><b>演示地址：</b><a href="https://www.cs.usfca.edu/~galles/visualization/CountingSort.html">Counting Sort</a></pre>
 * <pre><b>适用场景：</b>内容不多，数据集中场景</pre>
 * <img src="http://doc.yqjdcyy.com/9ad1408d-4e28-4e22-945e-3c09ff338c06.png">
 * <ul>
 *     <li>时间复杂度<pre>n+k</pre></li>
 *     <li>空间复杂度<pre>k</pre></li>
 *     <li>稳定性<pre>稳定</pre></li>
 * </ul>
 * @author qingju.yao
 * @date 2020/06/26
 */
public final class BucketSort {

    public static Integer[] sort(Integer[] array) {

        final int length = array.length;
        final Node[] nodes = new Node[length];
        final Integer[] limits = ArrayUtils.limit(array);
        final int min = limits[0];
        final int max = limits[1];
        if (min == max) {
            return array;
        }

        final int range = (max - min);
        for (int i = 0; i < length; i++) {
            Integer current = array[i];
            final int index = (current - min) * (length - 1) / range;
            Node node = nodes[index];
            if (null == node) {
                nodes[index] = new Node(current);
                continue;
            }
            while (null != node) {
                if (node.value <= current) {
                    if (null == node.next) {
                        node.next = new Node(current);
                        break;
                    }
                    node = node.next;
                } else {
                    node = new Node(node, current);
                    break;
                }
            }
        }

        // from bucket to array
        int index = 0;
        for (int i = 0; i < length; i++) {
            Node node = nodes[i];
            if (null == node) {
                continue;
            }

            while (null != node && null != node.value) {
                array[index++] = node.value;
                node = node.next;
            }
        }
        return array;
    }

    static class Node {

        private Node next;
        private Integer value;

        public Node(Node next, Integer value) {
            this.next = next;
            this.value = value;
        }

        public Node(Integer value) {
            this(null, value);
        }

        public Node() {
            this(null, null);
        }
    }
}

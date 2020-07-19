package com.yao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * Related Topics 数组 哈希表
 *
 * @author qingju.yao
 * @date 2020/07/12
 */
public class TwoSum {

    /**
     * 思路：两遍遍历，根据上下限减少遍历次数
     * <p>
     * 解答成功:
     * 执行耗时:99 ms,击败了10.59% 的Java用户
     * 内存消耗:39.8 MB,击败了5.06% 的Java用户
     *
     * @param nums
     * @param target
     * @return int[]
     * @author qingju.yao
     * @date 2020/7/12
     */
    public int[] solution(int[] nums, int target) {

        // 数组上下限
        int min = nums[0], max = min;
        // 取值上下限
        int rangeMin = min, rangMax = min;
        boolean bFirst = true;
        final int length = nums.length;

        for (int i = 0; i < length; i++, bFirst = false) {

            int left = nums[i];
            // check range
            if (!bFirst && left > max) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                int right = nums[j];
                if (left + right == target) {
                    return new int[]{i, j};
                }

                // check limit
                if (bFirst) {
                    if (right < min) {
                        min = right;
                    }
                    if (right > max) {
                        max = right;
                    }
                }
            }

            // check range
            if (bFirst) {
                rangMax = target - min;
            }
        }

        return new int[]{0, 1};
    }

    /**
     * 思路：Map 中 Key 为值，Value 为索引值
     * <p>
     * 解答成功:
     * 执行耗时:2 ms,击败了99.60% 的Java用户
     * 内存消耗:39.7 MB,击败了5.06% 的Java用户
     *
     * @param nums
     * @param target
     * @return int[]
     * @author qingju.yao
     * @date 2020/7/12
     */
    public int[] solutionByMap(int[] nums, int target) {

        final int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int value = nums[i];
            int need = target - value;
            if (map.containsKey(need)) {
                return new int[]{i, map.get(need)};
            } else {
                map.put(value, i);
            }
        }

        return null;
    }
}

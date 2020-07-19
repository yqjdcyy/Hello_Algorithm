package com.yao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难点：结果去重，N^3
 *
 * @author qingju.yao
 * @date 2020/07/17
 */
public class ThreeSum {

    /**
     * 思路：暴力拆解+ 排序解决结果重复问题
     * <p>
     * <font color="red">等待结果超时</font>
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author qingju.yao
     * @date 2020/7/17
     */
    public List<List<Integer>> solution(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        // sort
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            // jump the same nums
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < length; k++) {
                    if ((k != j + 1 && nums[k] == nums[k - 1])) {
                        continue;
                    }
                    if (0 == nums[i] + nums[j] + nums[k]) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }
        }

        return list;
    }

    /**
     * 思路：排序+ 左右指针
     * <p>
     * <pre>
     * 解答成功:
     * 执行耗时:37 ms,击败了17.74% 的Java用户
     * 内存消耗:43.6 MB,击败了98.74% 的Java用户
     * </pre>
     * <p>
     * 优化：限定最小值不大于 0
     * <p>
     * <pre>
     * 解答成功:
     * 执行耗时:31 ms,击败了27.40% 的Java用户
     * 内存消耗:43.5 MB,击败了99.37% 的Java用户
     * </pre>
     * <p>
     * 优化：优先移动重复的节点
     * <p>
     * <pre>
     * 解答成功:
     * 执行耗时:28 ms,击败了40.81% 的Java用户
     * 内存消耗:43.4 MB,击败了99.37% 的Java用户
     * </pre>
     * <p>
     * <font color="red">优化：移除非相等情况下的优先遍历+ 移动指针使用 ++-- 优化</font>
     * <p>
     * <pre>
     * 解答成功:
     * 执行耗时:21 ms,击败了97.86% 的Java用户
     * 内存消耗:43.4 MB,击败了99.37% 的Java用户
     * </pre>
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author qingju.yao
     * @date 2020/7/17
     */
    public List<List<Integer>> solutionByN2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        // sort
        Arrays.sort(nums);
        int length = nums.length;
        // 优化上限 i < length - 2 为 i < length - 2 && nums[i] <= 0
        for (int i = 0; i < length - 2 && nums[i] <= 0; i++) {
            // jump same
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = length - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                if (0 == result) {
                    list.add(Arrays.asList(nums[i], nums[left++], nums[right--]));

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (result < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }

    /**
     * 来源于 <a href="https://leetcode-cn.com/problems/3sum/comments/">gwl_wolf</a>用户
     * <p></p>
     * 解答成功:
     * 执行耗时:21 ms,击败了97.86% 的Java用户
     * 内存消耗:43.6 MB,击败了98.74% 的Java用户
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author qingju.yao
     * @date 2020/7/17
     */
    public List<List<Integer>> solution3(int[] nums) {

        List<List<Integer>> nlist = new ArrayList<>();

        // 1：排序
        Arrays.sort(nums);
        // 2：上限界定
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // 3：重复情况跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 4：双指针移动
                if (nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else {
                    nlist.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    // 3
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return nlist;
    }
}

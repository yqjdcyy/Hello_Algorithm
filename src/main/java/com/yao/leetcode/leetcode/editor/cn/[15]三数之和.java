package com.yao.leetcode.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
// 请你找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 示例： 
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2385 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
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
}
//leetcode submit region end(Prohibit modification and deletion)

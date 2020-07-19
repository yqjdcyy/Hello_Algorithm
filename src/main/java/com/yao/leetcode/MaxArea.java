package com.yao.leetcode;

/**
 * @author qingju.yao
 * @date 2020/07/16
 */
public class MaxArea {

    /**
     * 思路：穷举法
     * <p>
     * 解答成功:
     * 执行耗时:530 ms,击败了10.55% 的Java用户
     * 内存消耗:39.9 MB,击败了44.28% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/16
     */
    public int solution(int[] height) {

        int area = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return area;
    }

    /**
     * 思路：双指针法
     * <p>
     * 解答成功:
     * 执行耗时:4 ms,击败了69.80% 的Java用户
     * 内存消耗:39.9 MB,击败了40.71% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/16
     */
    public int solutionByDPointer(int[] height) {
        int area = 0;
        int length = height.length;
        for (int i = 0, j = length - 1; i < j; ) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }
}

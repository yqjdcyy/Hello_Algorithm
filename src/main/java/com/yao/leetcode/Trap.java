package com.yao.leetcode;

import java.util.Stack;

/**
 * @author qingju.yao
 * @date 2020/07/16
 */
public class Trap {

    /**
     * 思路：暴力解法
     * <p></p>
     * 解答成功:
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:39.8 MB,击败了12.86% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/19
     */
    public int solution(int[] height) {

        int area = 0;
        int length = height.length;
        if (length < 3) {
            return area;
        }

        for (int left = 0; left < length - 1; left++) {

            int sideLeft = height[left];
            if (height[left + 1] >= sideLeft) {
                continue;
            }
            int tmpRight = left + 1;
            for (int right = tmpRight; right < length; right++) {

                int sideRight = height[right];
                if (sideRight >= sideLeft) {
                    tmpRight = right;
                    break;
                } else if (sideRight > height[tmpRight]) {
                    tmpRight = right;
                }
            }

            if (tmpRight - left >= 2) {
                area += calcArea(height, left, tmpRight);
                left = tmpRight - 1;
            }
        }

        return area;
    }

    private int calcArea(int[] height, int left, int right) {

        int area = 0;
        int range = Math.min(height[left], height[right]);
        for (int i = left + 1; i < right; i++) {
            area += range - height[i];
        }

        return area;
    }

    /**
     * 思路：分别获取其左边最大和右边最大值后，再行累计高度
     * <p></p>
     * <p>
     * 解答成功:
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:39.3 MB,击败了12.86% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/19
     */
    public int solution2(int[] height) {

        int area = 0;
        int length = height.length;
        if (length < 3) {
            return area;
        }
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        for (int i = 1, curMax = height[0]; i < length - 1; i++) {
            leftMax[i] = curMax;
            // X 判断值录入错一次
            curMax = Math.max(curMax, height[i]);
        }
        for (int i = length - 2, curMax = height[length - 1]; i > 0; i--) {
            rightMax[i] = curMax;
            curMax = Math.max(curMax, height[i]);
        }

        for (int i = 1; i < length - 1; i++) {
            // X 方向比对错误一次
            if (leftMax[i] > height[i] && rightMax[i] > height[i]) {
                int curMax = Math.min(leftMax[i], rightMax[i]);
                if (curMax > height[i]) {
                    area += curMax - height[i];
                }
            }
        }

        return area;
    }

    /**
     * 思路：栈
     * <pre>
     * 栈存小边，遇大边则取值计算该层面积并累加
     * 效果参见<img src="https://pic.leetcode-cn.com/7d5ff9af88634d417d7925e8987b7db92d3a26766bd9078215ab63df424fa745-water.gif">live</img>
     * </pre>
     * <p></p>
     * 解答成功:
     * 执行耗时:3 ms,击败了36.62% 的Java用户
     * 内存消耗:39.7 MB,击败了12.86% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/19
     */
    public int solution3(int[] height) {

        int area = 0;
        int length = height.length;
        if (length < 3) {
            return area;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            // X 判断时遗忘存放的为索引值
            while (!stack.empty() && height[i] >= height[stack.peek()]) {
                int bottom = height[stack.pop()];
                // X 需要三条边
                if (0 == stack.size()) {
                    break;
                }
                int top = Math.min(height[stack.peek()], height[i]);
                int width = i - stack.peek() - 1;
                area += width * (top - bottom);
            }

            stack.push(i);
        }

        return area;
    }

    /**
     * 思路：双指针
     * <p></p>
     * 解答成功:
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:39.3 MB,击败了12.86% 的Java用户
     *
     * @param height
     * @return int
     * @author qingju.yao
     * @date 2020/7/19
     */
    public int solution4(int[] height) {

        int length = height.length;
        int left = 0, right = length - 1, leftMax = 0, rightMax = 0, area = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    // 当前最低边，决定了上限
                    area += rightMax - height[right];
                }
                right--;
            }
        }

        return area;
    }
}

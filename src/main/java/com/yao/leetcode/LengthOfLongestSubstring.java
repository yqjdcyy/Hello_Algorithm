package com.yao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <font color="red">
 * 单测情况想得不完整，导致效率极低
 * </font>
 *
 * @author qingju.yao
 * @date 2020/07/14
 */
public class LengthOfLongestSubstring {

    /**
     * 思路：Map 定位
     * <p>
     * 解答成功:
     * 执行耗时:83 ms,击败了16.78% 的Java用户
     * 内存消耗:40.8 MB,击败了5.20% 的Java用户
     *
     * @param s
     * @return int
     * @author qingju.yao
     * @date 2020/7/14
     */
    public int solutionByMap(String s) {

        // S0: 空字符串
        if (null == s || s.length() == 0) {
            return 0;
        }

        byte[] bytes = s.getBytes();
        int length = bytes.length;
        int max = 1, current = 0;
        Map<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {

            byte val = bytes[i];
            if (!map.containsKey(val)) {
                current++;
                map.put(val, i);
            } else {
                max = Math.max(max, current);
                i = map.get(val);
                map.clear();
                current = 0;
            }
        }

        max = Math.max(max, current);
        return max;
    }

    /**
     * 思路：数组定位
     * <p>
     * 解答成功:
     * 执行耗时:29 ms,击败了19.36% 的Java用户
     * 内存消耗:40.1 MB,击败了5.20% 的Java用户
     *
     * @param s
     * @return int
     * @author qingju.yao
     * @date 2020/7/14
     */
    public int solutionByArray(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        byte[] bytes = s.getBytes();
        int length = bytes.length;
        int max = 1, current = 0;
        // Char 为 ASCII 时上限至 256
        Integer[] indexes = new Integer[256];
        for (int i = 0; i < length; i++) {

            byte val = bytes[i];
            if (null == indexes[val]) {
                current++;
                indexes[val] = i;
            } else {
                max = Math.max(max, current);
                i = indexes[val];
                Arrays.fill(indexes, null);
                current = 0;
            }
        }

        max = Math.max(max, current);
        return max;
    }

    /**
     * 思路：基本思路为滑动窗口
     * <ul>
     * <li>注意事项</li>
     * <ol>
     *     <li>将空值判断合并在内</li>
     *     <li>右边界不要回缩</li>
     * </ol>
     * </ul>
     * <p>
     * 解答成功:
     * 执行耗时:3 ms,击败了96.92% 的Java用户
     * 内存消耗:39.7 MB,击败了5.54% 的Java用户
     *
     * @param s
     * @return int
     * @author qingju.yao
     * @date 2020/7/14
     */
    public int solutionBySlide(String s) {

        int max = 0, left = 0, right = 0;
        final int length = s.length();
        for (; left < length && right < length; right++) {
            char rVal = s.charAt(right);
            int rReIdx = s.indexOf(rVal, left);
            if (rReIdx > -1 && rReIdx != right) {
                max = Math.max(max, right - left);
                left = rReIdx + 1;
            }
        }

        max = Math.max(max, right - left);
        return max;
    }

    /**
     * 思路：滑动窗口（从后往左）
     *
     * <p>
     * 解答成功:
     * 执行耗时:3 ms,击败了96.92% 的Java用户
     * 内存消耗:39.8 MB,击败了5.20% 的Java用户
     *
     * @param s
     * @return int
     * @author qingju.yao
     * @date 2020/7/14
     */
    public int solutionByNextIndex(String s) {

        int left = 0, right = 0, current = 0, max = 0;
        final int length = s.length();
        while (right < length) {

            int index = s.indexOf(s.charAt(right), left);
            if (index < right) {

                max = Math.max(max, right - left);
                current = right - index;
                left = index + 1;
                right++;
                continue;
            }
            current++;
            right++;
        }
        max = Math.max(max, current);
        return max;
    }
}

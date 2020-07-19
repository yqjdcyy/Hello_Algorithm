package com.yao.leetcode;

/**
 * @author qingju.yao
 * @date 2020/07/15
 */
public class LongestPalindrome {

    /**
     * 解法：暴力过滤
     * <p>
     * 解答成功:
     * 执行耗时:605 ms,击败了6.12% 的Java用户
     * 内存消耗:37.9 MB,击败了26.78% 的Java用户
     *
     * @param s
     * @return java.lang.String
     * @author qingju.yao
     * @date 2020/7/15
     */
    public String solution(String s) {

        int max = 0;
        final int length = s.length();
        String result = "";

        for (int i = length - 1; i >= max; i--) {

            int idx = -1, curMax = 0;
            while ((idx = s.indexOf(s.charAt(i), idx + 1)) >= 0 && idx <= i) {
                boolean bCheck = true;
                for (int left = idx, right = i; left <= right; left++, right--) {
                    if (s.charAt(left) != s.charAt(right)) {
                        bCheck = false;
                        break;
                    }
                }
                if (bCheck && (curMax = i - idx + 1) > max) {
                    result = s.substring(idx, i + 1);
                    max = curMax;
                }
            }
        }

        return result;
    }

    /**
     * 解法：动态规划
     * <p>
     * 参考：
     * <pre>
     * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/">动态规划、中心扩散、Manacher 算法
     * </a>
     * </pre>
     * <p>
     * 解答成功:
     * 执行耗时:1440 ms,击败了5.00% 的Java用户
     * 内存消耗:40 MB,击败了15.18% 的Java用户
     *
     * @param s
     * @return java.lang.String
     * @author qingju.yao
     * @date 2020/7/15
     */
    public String solutionByDynamic(String s) {

        String result = "";
        int length = s.length();

        for (int i = 0; i < length - result.length(); i++) {
            for (int j = i + result.length(); j < length; j++) {
                if (deep(s, i, j) && (j - i + 1) > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    private boolean deep(String s, int left, int right) {

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return right - left < 3 ? true : deep(s, left + 1, right - 1);
    }

    /**
     * 解法：<font color="red">动态规划-表格法</font>
     * <p>
     * 参考：
     * <pre>
     * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/">动态规划、中心扩散、Manacher 算法
     * </a>
     * </pre>
     * <p>
     * 解答成功:
     * 执行耗时:73 ms,击败了52.91% 的Java用户
     * 内存消耗:42.4 MB,击败了15.18% 的Java用户
     *
     * @param s
     * @return java.lang.String
     * @author qingju.yao
     * @date 2020/7/15
     */
    public String solutionByDynamicTable(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }

        int start = 0, max = 1;
        // String.charAt-> byte[]: 42.5 MB->    42.7 MB && 31.33%->  52.91%
        byte[] bytes = s.getBytes();
        boolean[][] table = new boolean[length][length];

        for (int i = 1; i < length; i++) {
            table[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (bytes[i] != bytes[j]) {
                    table[i][j] = false;
                } else {
                    if (i - j < 3) {
                        table[i][j] = true;
                    } else {
                        table[i][j] = table[i - 1][j + 1];
                    }
                }
                // CurMax: 26.10%->  31.33%
                if (table[i][j] && (i - j + 1) > max) {
                    start = j;
                    max = i - j + 1;
                }
            }
        }

        return s.substring(start, start + max);
    }

    /**
     * 解法：<font color="red">动态规划-中心扩散</font>
     * <p>
     * 参考：
     * <pre>
     * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/">动态规划、中心扩散、Manacher 算法
     * </a>
     * </pre>
     * <p>
     * 解答成功:
     * 执行耗时:30 ms,击败了86.46% 的Java用户
     * 内存消耗:39.9 MB,击败了15.18% 的Java用户
     *
     * @param s
     * @return java.lang.String
     * @author qingju.yao
     * @date 2020/7/15
     */
    public String solutionByCenter(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }

        int max = 1;
        String result = s.substring(0, 1);

        for (int i = 0; i < length - 1 && i < length - max / 2; i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);
            String current = odd.length() > even.length() ? odd : even;
            if (current.length() > max) {
                max = current.length();
                result = current;
            }
        }

        return result;
    }

    private String expand(String s, int left, int right) {

        int length = s.length();
        int start = left, end = right;
        for (; start >= 0 && end < length; start--, end++) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }

        return s.substring(start + 1, end);
    }
}

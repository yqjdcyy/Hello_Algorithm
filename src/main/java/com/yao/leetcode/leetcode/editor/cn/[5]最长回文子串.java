package com.yao.leetcode.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_5 {
    public String longestPalindrome(String s) {

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
//leetcode submit region end(Prohibit modification and deletion)

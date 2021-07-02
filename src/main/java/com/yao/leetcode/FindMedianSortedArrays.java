package com.yao.leetcode;

/**
 * @author qingju.yao
 * @date 2020/07/20
 */
public class FindMedianSortedArrays {

    /**
     * 思路：<a href="">排除法</a>
     * <p></p>
     *
     * @param nums1
     * @param nums2
     * @return double
     * @author qingju.yao
     * @date 2020/7/20
     */
    public double solution(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        int offset = length % 2 == 1 ? 1 : 0;
        int remove = length / 2 - (offset);

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int start1 = Math.min(remove / 2 - 1, nums1.length - 1);
        int start2 = Math.max(remove / 2 - 1, remove - (start1 + 1) - 1);
        while (start1 >= 0 && remove > 0) {

        }

//        if (1 == offset) {
//            return start1 < 0 ? nums2[start2 + 1] : Math.max(nums1[start1], nums2[start2]);
//        } else {
//            return (start1< 0? ) /2;
//        }

        return 0D;
    }
}

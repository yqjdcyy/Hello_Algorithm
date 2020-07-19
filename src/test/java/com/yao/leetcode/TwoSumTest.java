package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    private TwoSum solution;

    @Before
    public void setUp() {

        solution = new TwoSum();
    }

    @Test
    public void solution() {

        int[] nums = {2, 7, 11, 12};
        int target = 9;

        int[] results = solution.solution(nums, target);
        Arrays.sort(results);
        Assert.assertTrue(Arrays.equals(results, new int[]{0, 1}));
    }

    @Test
    public void solutionByMap() {

        int[] nums = {2, 7, 11, 12};
        int target = 9;

        int[] results = solution.solutionByMap(nums, target);
        Arrays.sort(results);
        Assert.assertTrue(Arrays.equals(results, new int[]{0, 1}));
    }
}
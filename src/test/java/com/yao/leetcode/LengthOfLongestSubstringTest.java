package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring solution;
    private Map<String, Integer> caseMap;

    @Before
    public void setUp() throws Exception {
        solution = new LengthOfLongestSubstring();
        caseMap = new HashMap<String, Integer>() {{
            put("", 0);
            put("abc", 3);
            put("aab", 2);
            put("abb", 2);
            put("dvdf", 3);
            put("bbbbb", 1);
            put("pwwkew", 3);
            put("abcabcbb", 3);
        }};
    }

    @Test
    public void solution() {

        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            Assert.assertEquals(
                    Optional.ofNullable(caseMap.get(value)).orElse(0).intValue(),
                    solution.solutionByMap(value));
        }
    }

    @Test
    public void solution2() {

        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            Assert.assertEquals(
                    Optional.ofNullable(caseMap.get(value)).orElse(0).intValue(),
                    solution.solutionByArray(value));
        }
    }

    @Test
    public void solution3() {

        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            Assert.assertEquals(
                    Optional.ofNullable(caseMap.get(value)).orElse(0).intValue(),
                    solution.solutionBySlide(value));
        }
    }

    @Test
    public void solution4() {

        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
            Assert.assertEquals(
                    Optional.ofNullable(caseMap.get(value)).orElse(0).intValue(),
                    solution.solutionByNextIndex(value));
        }
    }


    //---------------------------------
    // Case Range
    //---------------------------------
    @Test
    public void range() {
        System.out.println((int) 'z');
        System.out.println((int) 'Z');
    }
}
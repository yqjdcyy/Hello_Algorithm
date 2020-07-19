package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindromeTest {

    LongestPalindrome solution;
    Map<String, String> caseMap;

    @Before
    public void setUp() throws Exception {

        solution = new LongestPalindrome();
        caseMap = new HashMap<String, String>() {{
            put("", "");
            put("a", "a");
            put("babad", "bab");
            put("cbbd", "bb");
            put("abcda", "a");
            put("ccc", "ccc");
        }};
    }

    @Test
    public void solution() {
        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String in = iterator.next();
            System.out.println("Current:\t" + in);
            Assert.assertEquals(caseMap.get(in), solution.solution(in));
        }
    }

    @Test
    public void solution2() {
        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String in = iterator.next();
            System.out.println("Current:\t" + in);
            Assert.assertEquals(caseMap.get(in), solution.solutionByDynamic(in));
        }
    }

    @Test
    public void solution3() {
        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String in = iterator.next();
            System.out.println("Current:\t" + in);
            Assert.assertEquals(caseMap.get(in), solution.solutionByDynamicTable(in));
        }
    }

    @Test
    public void solution4() {
        Iterator<String> iterator = caseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String in = iterator.next();
            System.out.println("Current:\t" + in);
            Assert.assertEquals(caseMap.get(in), solution.solutionByCenter(in));
        }
    }
}
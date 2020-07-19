package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumTest {

    private ThreeSum solution;
    private List<Object> caseList;

    @Before
    public void setUp() throws Exception {

        solution = new ThreeSum();
        caseList = new ArrayList<Object>() {{
            add(new int[]{-1, 0, 1, 2, -1, -4});
            add(2);
            add(new int[]{-2, 0, 1, 1, 2});
            add(2);
        }};
    }

    @Test
    public void solution() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution((int[]) caseList.get(i)).size());
        }
    }

    @Test
    public void solution2() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solutionByN2((int[]) caseList.get(i)).size());
        }
    }

    @Test
    public void solution3() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution3((int[]) caseList.get(i)).size());
        }
    }
}
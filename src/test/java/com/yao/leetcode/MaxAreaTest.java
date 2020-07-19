package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaTest {

    private MaxArea solution;
    private List<Object> caseList;

    @Before
    public void setUp() throws Exception {

        solution = new MaxArea();
        caseList = new ArrayList<Object>() {{

            add(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
            add(49);
            add(new int[]{8, 6, 3, 9});
            add(24);
            add(new int[]{8, 6, 4});
            add(8);
        }};
    }

    @Test
    public void solution() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution((int[]) caseList.get(i)));
        }
    }

    @Test
    public void solutionByDPointer() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solutionByDPointer((int[]) caseList.get(i)));
        }
    }
}
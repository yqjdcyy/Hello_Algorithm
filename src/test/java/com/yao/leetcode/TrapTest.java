package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrapTest {

    private Trap solution;
    private List<Object> caseList;

    @Before
    public void setUp() throws Exception {

        solution = new Trap();
        caseList = new ArrayList<Object>() {{

            add(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
            add(6);
            add(new int[]{8, 6, 3, 9});
            add(7);
            add(new int[]{8, 6, 3, 2});
            add(0);
            add(new int[]{2});
            add(0);
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
    public void solution2() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution2((int[]) caseList.get(i)));
        }
    }

    @Test
    public void solution3() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution3((int[]) caseList.get(i)));
        }
    }

    @Test
    public void solution4() {

        int size = caseList.size();
        for (int i = 0; i < size; i += 2) {
            Assert.assertEquals(
                    caseList.get(i + 1),
                    solution.solution4((int[]) caseList.get(i)));
        }
    }
}
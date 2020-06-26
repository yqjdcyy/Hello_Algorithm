package com.yao.utils;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author qingju.yao
 * @date 2020/06/24
 */
public final class ArrayUtils {

    public static Integer[] init(int size) {

        Integer[] array = new Integer[size];

        final ArrayList<Integer> list = new ArrayList<Integer>();
        final Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(size));
        }

        Collections.shuffle(list);
        list.toArray(array);
        return array;
    }

    public static void print(Integer[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swap(Integer[] array, int left, int right) {

        final int length = array.length;
        assert left < length && left >= 0;
        assert right < length && right >= 0;

        final Integer tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }

    public static Integer[] sort(Integer[] array) {

        Assert.assertTrue(null != array && array.length > 0);

        final int length = array.length;
        final ArrayList<Integer> list = new ArrayList<>(length);
        Arrays.stream(array).forEach(p -> list.add(p));

        final Integer[] newArr = new Integer[length];
        Collections.sort(list);
        return list.toArray(newArr);
    }

    public static Integer[] limit(Integer[] array) {

        int min = array[0];
        int max = min;

        final int length = array.length;
        for (int i = 1; i < length; i++) {
            final Integer value = array[i];
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        return new Integer[]{min, max};
    }
}

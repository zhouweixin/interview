package com.zhou.datastruct;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet extends TestCase {

    public void test1() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = {0};
        int[] num2 = {0};

        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Integer res = array[0];
        for (int i = 1; i < array.length; i++) {
            res ^= array[i];
        }

        String str = Integer.toString(res, 2);
        int n = str.length() - str.indexOf("1");

        Integer res1 = -1;
        Integer res2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (isOne(n, array[i])) {
                if (res1 == -1) {
                    res1 = array[i];
                } else {
                    res1 ^= array[i];
                }
            } else {
                if (res2 == -1) {
                    res2 = array[i];
                } else {
                    res2 ^= array[i];
                }
            }
        }

        num1[0] = res1;
        num2[0] = res2;
    }

    public boolean isOne(int n, Integer x) {
        String str = Integer.toString(x, 2);
        int i = str.length() - n;
        if (str.length() < n || str.charAt(i) == '0') {
            return false;
        }

        return true;
    }
}

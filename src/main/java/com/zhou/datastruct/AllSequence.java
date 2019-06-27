package com.zhou.datastruct;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class AllSequence extends TestCase {

    // 1234

    /**
     * 回溯
     */
    public void test3() {
        int n = 9;
        int m = 9;

        int[] a = new int[m];
        int curIdx = 0;
        a[curIdx] = 1;
        while (true) {
            // 重复出现
            boolean flag = false;
            for (int i = 0; i < curIdx; i++) {
                if (a[curIdx] == a[i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {

            } else {
                if (curIdx + 1 == m) {
                    // 找到了一种结果
                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i]);
                    }
                    System.out.println();
                } else {
                    curIdx++;
                    a[curIdx] = 1;
                    continue;
                }
            }

            while (curIdx >= 0 && a[curIdx] >= n) {
                // 回溯
                curIdx--;
            }

            if (curIdx < 0) {
                break;
            } else {
                a[curIdx]++;
            }
        }
    }

    /**
     * 插入法
     */
    @Test
    public void test1() {
        String str = "ABCDE";

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (list1.size() == 0) {
                list1.add(c + "");
                continue;
            }

            for (String s : list1) {
                for (int j = 0; j <= s.length(); j++) {
                    list2.add(new StringBuilder(s).insert(j, c).toString());
                }
            }
            list1.clear();
            list1.addAll(list2);
            list2.clear();
        }
        Collections.sort(list1);
        list1.stream().forEach(System.out::println);
    }

    /**
     * 回溯法
     */
    @Test
    public void test2() {
        // A(n, m):从n个不同元素里任取m个排列
        int[] a = new int[30];
        long s = 0;

        int n = 4;
        int m = 4;
        int i = 1;
        a[i] = 1;
        while (true) {
            // 判断是否重复
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (a[j] == a[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (i < m) {
                    i++;
                    a[i] = 1;
                    continue;
                } else {
                    s++;
                    for (int j = 1; j <= m; j++) {
                        System.out.print(a[j]);
                    }
                    System.out.println();
                }
            }

            // 回溯
            while (a[i] == n) {
                i--;
            }

            if (i > 0)
                a[i]++;
            else
                break;
        }
        System.out.println("s = " + s);
    }
}

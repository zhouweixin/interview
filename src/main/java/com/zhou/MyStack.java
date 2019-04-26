package com.zhou;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Stack;

public class MyStack extends TestCase {
    /**
     * 判断出栈序列
     *
     * @param pushA：与popA大小相同
     * @param popA
     * @return
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (j < popA.length && popA[j] == s.peek()) {
                j++;
                s.pop();
            }
        }
        return s.size() == 0;
    }

    public void test1() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] a1 = new int[]{4, 5, 3, 2, 1};
        int[] a2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopOrder(a, a1));
        System.out.println(isPopOrder(a, a2));

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.removeLast();
        System.out.println(list);
    }
}

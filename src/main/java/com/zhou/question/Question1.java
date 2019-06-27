package com.zhou.question;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Question1 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int res = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                times = 1;
                res = array[i];
            } else if (res == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        // 验证找到的数字
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                count++;
            }
        }
        if (count * 2 > array.length) {
            return res;
        }
        return 0;
    }
}

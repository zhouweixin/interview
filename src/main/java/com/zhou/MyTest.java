package com.zhou;

public class MyTest {
    public static void main(String[] args) {
        String str1 = new String("ACEBFD");
        String str2 = new String();

        while (str1.length() > 0) {
            // 1.最后移动到最前
            str2 = moveToFirst(str2);

            // 2.转移
            str2 = str1.charAt(str1.length() - 1) + str2;
            str1 = str1.substring(0, str1.length() - 1);
        }
        System.out.println(str2);
    }

    public static String moveToFirst(String str) {
        if (str.length() < 2) {
            return str;
        }

        str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        return str;
    }
}

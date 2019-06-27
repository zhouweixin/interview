package com.zhou.designpattern.single;

/**
 * 懒汉式写法: 线程不安全
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

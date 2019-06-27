package com.zhou.designpattern.single;

/**
 * 饿汉式写法: 线程安全
 */
public class Singleton1 {
    private static final Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance(){
        return singleton1;
    }
}



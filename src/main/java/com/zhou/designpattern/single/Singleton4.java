package com.zhou.designpattern.single;

/**
 * 双重校验锁: 线程安全
 */
public class Singleton4{
    private static volatile Singleton4 singleton4 = null;

    public static Singleton4 getInstance(){
        if(singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}

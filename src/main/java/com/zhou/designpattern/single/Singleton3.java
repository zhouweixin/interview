package com.zhou.designpattern.single;

/**
 * 懒汉式写法: 线程安全
 */
public class Singleton3{
    private static Singleton3 singleton3 = null;

    public static synchronized Singleton3 getInstance(){
        if(singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
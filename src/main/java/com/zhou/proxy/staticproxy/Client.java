package com.zhou.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        ISinger target = new Singer();
        ISinger proxy = new SingerProxy(target);
        proxy.sing();
    }
}

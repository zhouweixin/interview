package com.zhou.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Marry marry = new Marry("张三", "李四");

        IMarry marryProxy = (IMarry)Proxy.newProxyInstance(marry.getClass().getClassLoader(),
                marry.getClass().getInterfaces(),
                new WeddingCompany(marry));
        marryProxy.marry();
    }
}

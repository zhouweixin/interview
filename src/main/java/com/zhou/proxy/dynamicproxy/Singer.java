package com.zhou.proxy.dynamicproxy;

public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("唱一首歌");
    }
}

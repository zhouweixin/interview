package com.zhou.designpattern.simplefactory;

/**
 * 具体产品
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑种人皮肤是黑色的");
    }

    @Override
    public void talk() {
        System.out.println("黑种人说话了");
    }
}

package com.zhou.designpattern.abstractfactory;

/**
 * 抽像产品类
 */
public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑种人皮肤是黑色的");
    }

    @Override
    public void talk() {
        System.out.println("黑种人说话了");
    }
}

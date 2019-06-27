package com.zhou.designpattern.abstractfactory;

/**
 * 抽像产品类
 */
public abstract class AbstractYelloHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄种人皮肤是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话了");
    }
}

package com.zhou.designpattern.simplefactory;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        // 生产黄种人
        YelloHuman yelloHuman = HumanFactory.createHuman(YelloHuman.class);
        yelloHuman.getColor();
        yelloHuman.talk();

        // 生产黑种人
        BlackHuman blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
    }
}

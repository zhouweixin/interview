package com.zhou.designpattern.abstractfactory;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();

        // 生产黄种人男
        System.out.println("=========================");
        Human maleYelloHuman = maleHumanFactory.createYelloHuman();
        maleYelloHuman.getColor();
        maleYelloHuman.talk();
        maleYelloHuman.getSex();

        // 生产黄种人女
        System.out.println("=========================");
        Human femaleYelloHuman = femaleHumanFactory.createYelloHuman();
        femaleYelloHuman.getColor();
        femaleYelloHuman.talk();
        femaleYelloHuman.getSex();

        // 生产黑种人男
        System.out.println("=========================");
        Human maleBlackHuman = maleHumanFactory.createBlackHuman();
        maleBlackHuman.getColor();
        maleBlackHuman.talk();
        maleBlackHuman.getSex();

        // 生产黑种人女
        System.out.println("=========================");
        Human femaleBlackHuman = femaleHumanFactory.createBlackHuman();
        femaleBlackHuman.getColor();
        femaleBlackHuman.talk();
        femaleBlackHuman.getSex();
    }
}

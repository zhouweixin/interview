package com.zhou.designpattern.abstractfactory;

public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑种人男");
    }
}

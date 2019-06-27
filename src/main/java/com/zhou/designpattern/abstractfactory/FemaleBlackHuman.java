package com.zhou.designpattern.abstractfactory;

public class FemaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑种人女");
    }
}

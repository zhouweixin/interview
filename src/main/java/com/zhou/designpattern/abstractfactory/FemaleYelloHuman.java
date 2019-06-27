package com.zhou.designpattern.abstractfactory;

public class FemaleYelloHuman extends AbstractYelloHuman {
    @Override
    public void getSex() {
        System.out.println("黄种人女");
    }
}

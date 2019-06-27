package com.zhou.designpattern.abstractfactory;

public class MaleYelloHuman extends AbstractYelloHuman {
    @Override
    public void getSex() {
        System.out.println("黄种人男");
    }
}

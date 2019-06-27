package com.zhou.designpattern.abstractfactory;

public class FemaleHumanFactory implements HumanFactory {

    @Override
    public Human createYelloHuman() {
        return new FemaleYelloHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}

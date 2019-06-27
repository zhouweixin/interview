package com.zhou.designpattern.abstractfactory;

public class MaleHumanFactory implements HumanFactory {

    @Override
    public Human createYelloHuman() {
        return new MaleYelloHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}

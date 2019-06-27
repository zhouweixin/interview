package com.zhou.proxy.dynamicproxy;

public class Marry implements IMarry {

    private String man;
    private String woman;

    public Marry(String man, String woman) {
        this.man = man;
        this.woman = woman;
    }

    @Override
    public void marry(){
        System.out.println(String.format("%s 和 %s 结婚了！", man, woman));
    }
}

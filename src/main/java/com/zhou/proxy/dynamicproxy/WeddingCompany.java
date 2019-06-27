package com.zhou.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WeddingCompany implements InvocationHandler {
    private IMarry target;

    public WeddingCompany(IMarry target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("发请贴");
        System.out.println("拍婚纱照");
        System.out.println("买五金");
        System.out.println("搭礼台");
        System.out.println("举办婚礼");
        Object o = method.invoke(target, args);
        System.out.println("宴请亲朋好友");
        System.out.println("欢送亲朋好友");
        System.out.println("收拾道具");

        return o;
    }
}

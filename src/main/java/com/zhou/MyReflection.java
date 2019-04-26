package com.zhou;

import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {
    static class Node {
        private int a;

        public Node(int a) {
            this.a = a;
        }

        public void print() {
            System.out.println("打印：" + a);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Node node = new Node(3);

        // 反射获取所有字段
        Field[] fields = node.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // 通过方法名反射获取
        Method method = node.getClass().getMethod("print");
        System.out.println(method.getName());

        // 通过反射调用方法
        method.invoke(node);
    }
}

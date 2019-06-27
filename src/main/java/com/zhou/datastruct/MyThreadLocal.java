package com.zhou.datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal {

    private static ThreadLocal<Integer> value1 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };
    private static int value2 = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyThread(i+1).start();
        }
    }

    static class MyThread extends Thread{

        private int index;

        public MyThread(int index){
            this.index = index;
        }

        @Override
        public void run(){
            System.out.println("线程: " + index + ", 初始值: value1 = " + value1.get() + ", value2 = " + value2);
            for (int i = 0; i < 10; i++) {
                value1.set(value1.get() + i);
                value2 += i;
            }
            System.out.println("线程: " + index + ", 累加值: value1 = " + value1.get() + ", value2 = " + value2);
        }
    }
}

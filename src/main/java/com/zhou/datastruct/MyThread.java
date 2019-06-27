package com.zhou.datastruct;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread {
    private static volatile int value = 0;
    private static volatile AtomicInteger value2 = new AtomicInteger(0);

    private static void increment() {
        value++;
        value2.getAndIncrement();
    }

    public void testVolatile(){
        System.out.println("value = " + value);
        System.out.println("value2 = " + value2);

        Thread[] ts = new Thread[10];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 2000; i++) {
                        increment();
                    }
                }
            };
        }
        for (Thread t : ts) {
            t.start();
        }

        while (Thread.activeCount() > 2) {
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println("value = " + value);
        System.out.println("value2 = " + value2);
    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("我是线程1");
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("我是线程2");
        }
    }

    class Thread3 implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("我是线程3");
            return 3;
        }
    }

    /**
     * 多线程的3种实现方式：Thread, Runnable, Callable
     */
    @Test
    public void testThread() {
        new Thread1().start();
        new Thread(new Thread2()).start();
        new Thread(new FutureTask<>(new Thread3())).start();
    }

    /**
     * 线程池
     */
    public void testThreadPool(){
        // 固定大小
        ExecutorService pool1 = Executors.newFixedThreadPool(3);
        // 自适应大小
        ExecutorService pool2 = Executors.newCachedThreadPool();
        // 定时
        ExecutorService pool3 = Executors.newScheduledThreadPool(3);
        // 单例
        ExecutorService pool4 = Executors.newSingleThreadExecutor();
    }

    int scheduleNum = 0;
    public void testScheduledThreadPool(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 3; i++) {
            pool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(scheduleNum);
                    scheduleNum++;
                }
            }, 1, 3, TimeUnit.SECONDS);
        }
    }

    static int num = 0;

    /**
     * 测试单例
     */
    public void testSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 测试单例线程池：一个线程异常结束，会创建新的线程来执行后面的任务
        for (int i = 0; i < 3; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        num++;
                        if (num % 5 == 0) {
                            System.out.println("异常：" + num);
                            throw new NullPointerException();
                        }
                        System.out.println(num);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new MyThread().testVolatile();
//        new MyThread().testScheduledThreadPool();
//        new MyThread().testSingleThreadExecutor();
    }
}

package com.zhou;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    private Lock lock = new ReentrantLock();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void add1(String threadName) {

        // 获取锁
        lock.lock();

        for (int i = 0; i < 5; i++) {
            list1.add(i);
            System.out.println(threadName + ": " + list1);
        }

        lock.unlock();
    }

    public void add2(String threadName) {
        // 不会阻塞
        if (lock.tryLock()) {
            for (int i = 0; i < 5; i++) {
                list1.add(i);
                System.out.println(threadName + ": " + list1);
            }

            lock.unlock();
        }
    }

    public synchronized void add3(String threadName) {
        for (int i = 0; i < 5; i++) {
            list2.add(i);
            System.out.println(threadName + ": " + list2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();


        Thread t1 = new Thread() {
            @Override
            public void run() {
                myLock.add1("线程1");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                myLock.add1("线程2");
            }
        };

        t1.start();
        t2.start();

        Thread.sleep(2000);

        Thread t3 = new Thread() {
            @Override
            public void run() {
                myLock.add3("线程3");
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                myLock.add3("线程4");
            }
        };
        t3.start();
        t4.start();
    }

}

package com.example.ming.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 第一个线程输出【ABCDEF】，第二个线程输出【123456】，两个线程交替输出[A1B2C3D4E5F6]
 * 使用一个变量来标志t1先执行， 解决t1先执行 t2后执行
 * @author: wangzhx
 * @create: 2020-10-17 16:42
 */
public class LoopOutput05_sync_wait_notify {


    static Thread t1, t2 = null;

    private static volatile boolean t1Started = false;


    public static void main(String[] args) {
        Object o = new Object();
        String s1 = "ABCDEF";
        String s2 = "123456";

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();


        t1 = new Thread(() -> {
            synchronized (o) {
                t1Started = true;
                for (char c : chars1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify(); //不最后notify 最后会有一个线程不会停止一直在wait
            }
        });

        t2 = new Thread(() -> {
            synchronized (o) {
                while (!t1Started){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (char c : chars2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify(); //不最后notify 最后会有一个线程不会停止一直在wait
            }
        });

        // 但是这种方式不能保证t1 先执行 t2 后执行
        t2.start();
        t1.start();

    }
}
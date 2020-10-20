package com.example.ming.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @description: 第一个线程输出【ABCDEF】，第二个线程输出【123456】，两个线程交替输出[A1B2C3D4E5F6]
 * @author: wangzhx
 * @create: 2020-10-17 16:42
 */
public class LoopOutput01_lock_support {

    static Thread t1, t2 = null;

    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "123456";

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        t1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park();// park 方法执行时，检查之前是否该线程被unpark，如果被unpark，则此次park不生效，继续执行。
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
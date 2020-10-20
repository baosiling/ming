package com.example.ming.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @description: 第一个线程输出【ABCDEF】，第二个线程输出【123456】，两个线程交替输出[A1B2C3D4E5F6]
 * @author: wangzhx
 * @create: 2020-10-17 16:42
 */
public class LoopOutput02_while {

    private static volatile boolean flag = true;

    static Thread t1, t2 = null;

    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "123456";

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();


        t1 = new Thread(() -> {
            for (char c : chars1) {
                while (!flag) {
                }
                System.out.print(c);
                flag= false;
            }
        });

        t2 = new Thread(() -> {
            for (char c : chars2) {
                while (flag) {
                }
                System.out.print(c);
                flag = true;
            }
        });

        t1.start();
        t2.start();
    }
}
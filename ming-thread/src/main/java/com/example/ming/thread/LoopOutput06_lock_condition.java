package com.example.ming.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 第一个线程输出【ABCDEF】，第二个线程输出【123456】，两个线程交替输出[A1B2C3D4E5F6]
 * 使用ReentrantLock 中的condition来解决
 * conditionT1 代表lock上的一个线程队列A
 * conditionT2 代表lock上的一个线程队列B
 *
 * conditionT1.await 表示将当前线程加入A队列，释放lock
 * conditionT2.signal 表示将B队列中的线程出队，获取lock
 *
 * @author: wangzhx
 * @create: 2020-10-17 16:42
 */
public class LoopOutput06_lock_condition {

    static Thread t1, t2 = null;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        String s1 = "ABCDEF";
        String s2 = "123456";

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();


        t1 = new Thread(() -> {
            lock.lock();
            for (char c : chars1) {
                System.out.print(c);
                try {
                    condition2.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition2.signal();
            lock.unlock();
        });

        t2 = new Thread(() -> {
            lock.lock();
            for (char c : chars2) {
                System.out.print(c);
                try {
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition1.signal();
            lock.unlock();
        });

        t1.start();
        t2.start();

    }
}
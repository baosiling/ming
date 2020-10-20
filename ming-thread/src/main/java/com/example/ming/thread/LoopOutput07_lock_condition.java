package com.example.ming.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 第一个线程输出【ABCDEF】，第二个线程输出【123456】，第三个线程输出【abcdef】 三个线程交替输出[A1aB2bC3cD4dE5eF6f]
 *  ReentrantLock 可以new出多个condition，方便控制这个锁上的多个线程队列
 * @author: wangzhx
 * @create: 2020-10-17 16:42
 */
public class LoopOutput07_lock_condition {

    static Thread t1, t2, t3 = null;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        String s1 = "ABCDEF";
        String s2 = "123456";
        String s3 = "abcdef";

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();


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
                    condition3.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition3.signal();
            lock.unlock();
        });

        t3 = new Thread(()->{
            lock.lock();
            for (char c : chars3) {
                System.out.print(c);
                try {
                    condition1.signal();
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition1.signal();
            lock.unlock();
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
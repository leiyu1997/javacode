package com.leiyu.multithread;

/**
 * java多线程的死锁实现（静态）
 */
public class DeadLock {

    public static String A = "A";
    public static String B = "B";

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockRun1(), "线程T1");
        Thread t2 = new Thread(new DeadLockRun2(), "线程T2");
        t1.start();
        t2.start();
    }
}

class DeadLockRun1 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.A) {
            System.out.println(Thread.currentThread().getName() + "获取到" + DeadLock.A);
            try {
                Thread.sleep(200);
                synchronized (DeadLock.B) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + DeadLock.B);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行结束。");
    }
}

class DeadLockRun2 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.B) {
            System.out.println(Thread.currentThread().getName() + "获取到" + DeadLock.B);
            try {
                Thread.sleep(200);
                synchronized (DeadLock.A) {
                    System.out.println(Thread.currentThread().getName() + "获取到" + DeadLock.A);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行结束。");
    }
}

package com.leiyu.multithread;

/**
 * @program: javacode
 * @description: 死锁（非静态）
 * @author: yuleif
 * @create: 2020-09-23 16:57
 **/
public class DeadLock2 {
    public static void main(String[] args) {
        Object A = "A";
        Object B = "B";
        Thread t1 = new Thread(new Run(A, B), "t1");
        Thread t2 = new Thread(new Run(B, A), "t2");
        t1.start();
        t2.start();
    }
}

class Run implements Runnable {
    Object A;
    Object B;

    Run(Object A, Object B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行。。。");
        synchronized (A) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (B) {

            }
        }
        System.out.println(Thread.currentThread().getName() + "线程执行完毕");
    }
}

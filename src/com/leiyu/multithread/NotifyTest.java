package com.leiyu.multithread;

/**
 * 实现线程的交替打印
 */
public class NotifyTest {

    public static Integer source = 0;

    public static void main(String[] args) {
        Runnable Run=new NotifyRun();
        Thread t1 = new Thread(Run, "A");
        Thread t2 = new Thread(Run, "B");
        t1.start();
        t2.start();
    }

}

class NotifyRun implements Runnable {
    @Override
    public void run() {
        while (true) {
            //由于锁定的是static对象，所以需要锁住类的class，这样便锁住了类静态成员变量和所有的类实例
            //wait 和 notify 方法必须在同步代码块中调用
            synchronized (NotifyTest.class) {
                System.out.println(Thread.currentThread().getName() + ":" + NotifyTest.source++);
                try {
                    NotifyTest.class.notifyAll();
                    NotifyTest.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (NotifyTest.source > 100) {
                    NotifyTest.class.notifyAll();
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}


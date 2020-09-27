package com.leiyu.multithread.threadpool;

import java.util.concurrent.*;

/**
 * @program: javacode
 * @description: countdownlatch测试
 * @author: yuleif
 * @create: 2020-09-24 20:40
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(0, 4, 1, TimeUnit.SECONDS, new SynchronousQueue<>());
        CountDownLatch count=new CountDownLatch(5);
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        count.countDown();
        try {
            count.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("执行结束");
        pool.shutdown();
    }
}

class CountDownLatchRun implements Runnable{
    CountDownLatch count;
    CountDownLatchRun(CountDownLatch count){
        this.count=count;
    }
    @Override
    public void run() {
        count.countDown();
        try {
            count.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("线程执行");
    }
}

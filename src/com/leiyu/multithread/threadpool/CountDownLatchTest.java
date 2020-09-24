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
        ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        CountDownLatch count=new CountDownLatch(100);
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        pool.execute(new CountDownLatchRun(count));
        count.countDown();
        try {
            Thread.sleep(200);
        }catch (Exception e){

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
        System.out.println("线程执行");
    }
}

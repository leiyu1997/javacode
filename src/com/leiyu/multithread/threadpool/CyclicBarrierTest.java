package com.leiyu.multithread.threadpool;

import java.util.concurrent.*;

/**
 * @program: javacode
 * @description: 同步屏障测试
 * @author: yuleif
 * @create: 2020-09-24 20:50
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS, new SynchronousQueue<>());
        CyclicBarrier cyclicBarrier =new CyclicBarrier(4);
        pool.execute(new CyclicBarrierRun(cyclicBarrier));
        pool.execute(new CyclicBarrierRun(cyclicBarrier));
        pool.execute(new CyclicBarrierRun(cyclicBarrier));
        pool.execute(new CyclicBarrierRun(cyclicBarrier));
        try {
            cyclicBarrier.await();
            System.out.println("线程结束");
        }catch (Exception e){
            e.printStackTrace();
        }
        pool.shutdown();
    }
}

class CyclicBarrierRun implements Runnable{
    CyclicBarrier cyclicBarrier;

    CyclicBarrierRun(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            System.out.println("线程执行");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

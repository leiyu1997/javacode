package com.leiyu.multithread.threadpool;

import java.util.concurrent.*;

/**
 * 线程池是用来创建线程的，加入的job会在创建的线程中运行
 */
public class InitThreadPool {
    public static Integer threadCount = 0;


    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5,//核心线程池数
                5,//最大线程池数
                3,//空闲线程的存活时间
                TimeUnit.SECONDS,//空闲线程的存活时间单位
                new LinkedBlockingDeque<>(3),//阻塞队列
                new MyThreadFactory(),//线程创建
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        Run run = new Run();
        Call call=new Call();
        Future<String> future = pool.submit(call);
        try {
            System.out.println("main"+future.get());
        } catch (Exception e) {
            throw new RuntimeException("asfasf");
        }
        pool.execute(run);
        pool.submit(run);
        pool.shutdown();
    }
}

class Run implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行");
    }
}

class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "执行");
        return Thread.currentThread().getName() + "执行";
    }
}


class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        int n;
        synchronized (InitThreadPool.class) {
            n = InitThreadPool.threadCount++;
        }
        return new Thread(r, "Thread" + n);
    }
}

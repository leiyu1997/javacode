package com.leiyu.multithread.threadpool;

import java.util.concurrent.*;

public class ExchangerTest {
    public static Exchanger<String> EXCHANGER=new Exchanger<>();
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r.toString());
            }
        },new ThreadPoolExecutor.AbortPolicy());
//        new Thread(new ExchangerRun("AAA",EXCHANGER)).start();
//        new Thread(new ExchangerRun("BBB",EXCHANGER)).start();
        pool.execute(new ExchangerRun("AAA",EXCHANGER));
        pool.execute(new ExchangerRun("BBB",EXCHANGER));
        pool.shutdown();
    }
}

class ExchangerRun implements Runnable{
    String a;
    Exchanger<String> exchanger;
    ExchangerRun(String text,Exchanger<String> exchanger){
        this.a=text;
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        try {
            String b=exchanger.exchange(a);
            System.out.println(a+":"+b);
        }catch (Exception e){

        }
    }
}

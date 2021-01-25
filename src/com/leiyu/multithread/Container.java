package com.leiyu.multithread;

import java.util.ArrayList;
import java.util.List;

public class Container {

    public static List<Object> data_Pool = new ArrayList<>();

    public static void add(Object obj) {
        data_Pool.add(obj);
    }

    public static int size() {
        return data_Pool.size();
    }
}

class kkk {
    public static void main(String[] args) {
        Thread addObj = new Thread(new RunAdd());
        Thread monitor = new Thread(new RunMonitor(addObj));
        addObj.start();
        monitor.start();
    }
}

class RunAdd implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Container.class) {
                Container.add(new Object());
                try {
                    Container.class.notifyAll();
                    Container.class.wait();
                } catch (Exception e) {

                }
            }
        }
    }
}

class RunMonitor implements Runnable {
    Thread thread;

    RunMonitor(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Container.class) {
                try {
                    if (Container.size() != 5) {
                        Container.class.notifyAll();
                        Container.class.wait();
                    } else {
                        thread.stop();
                        System.out.println("容器中已经有5个元素");
                        break;
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

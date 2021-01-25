package com.leiyu.multithread;

public class Main {
    public static Integer Av=1;
    public static Integer Bv=2;
    public static void main(String[] args) {
        Thread A=new Thread(new MyRunnable(Av,"A"));
        Thread B=new Thread(new MyRunnable(Bv,"B"));
        A.start();
        B.start();
        A.stop();
        B.stop();
    }
}

class MyRunnable implements Runnable{
    Integer value;
    String name;
    MyRunnable(Integer value,String name){
        this.value=value;
        this.name=name;
    }

    @Override
    public void run() {
        while (value<=100){
            synchronized (Main.class){
                System.out.println(name+":"+value++);
                value++;
                Main.class.notifyAll();
                try {
                    Main.class.wait();
                }catch (Exception e){

                }
            }
        }
    }
}
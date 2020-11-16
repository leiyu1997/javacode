package com.leiyu.main;

import java.util.ArrayDeque;

public class Solution {
    public static ArrayDeque<Object> deque;
    static {
        deque=new ArrayDeque<Object>(5);
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Produce(deque));
        Thread t2=new Thread(new Consume(deque));
        t1.start();
        t2.start();
    }


}

class Produce implements Runnable{

    ArrayDeque<Object> arrayDeque;

    Produce(ArrayDeque<Object> deque){
        this.arrayDeque=deque;
    }

    @Override
    public void run() {
        while (true){
            synchronized (arrayDeque){
                try {
                    if(arrayDeque.size()==5){
                        arrayDeque.getClass().notifyAll();
                        arrayDeque.getClass().wait();
                    }else {
                        arrayDeque.add("1");
                        System.out.println("produceIng");
                    }
                }catch (Exception e){

                }
            }
        }
    }
}

class Consume implements Runnable{

    ArrayDeque<Object> arrayDeque;

    Consume(ArrayDeque<Object> deque){
        this.arrayDeque=deque;
    }

    @Override
    public void run() {
        while (true){
            synchronized (arrayDeque){
                try {
                    if(!arrayDeque.isEmpty()){
                        System.out.println(arrayDeque.poll());
                    }
                    if(arrayDeque.isEmpty()){
                        arrayDeque.getClass().notifyAll();
                        arrayDeque.getClass().wait();
                    }
                }catch (Exception e){

                }
            }
        }
    }
}

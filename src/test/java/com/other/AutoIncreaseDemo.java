package com.other;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoIncreaseDemo implements Runnable{

    private Counter counter;
    private Integer count;
    private Integer count1;
    private AtomicInteger atomicInteger;

    AutoIncreaseDemo(Counter counter,Integer count, Integer count1,AtomicInteger atomicInteger){
        this.counter = counter;
        this.count = count;
        this.count1 = count1;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        try{
            for(int i =0;i<100;i++){
                counter.inCreaseNum();
                ++count;
                ++count1;
                atomicInteger.getAndIncrement();
            }
            //Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }


        //System.out.println("counter : "+counter.getValue());
        System.out.println("count : "+count.hashCode());
        System.out.println("counter1 : "+count1.hashCode());
        //System.out.println("atomicInteger : "+atomicInteger.intValue());
        System.out.println("-------------------------------------");
    }
}


class AutoIncreaseTest{
    private static Counter counter = new Counter();
    private static Integer count = new Integer(0);
    private static volatile Integer count1 = new Integer(0);
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String args[])throws InterruptedException{
        AutoIncreaseDemo autoIncreaseDemo = new AutoIncreaseDemo(counter,count,count1,atomicInteger);
        Thread t1 ;
        for(int i=0;i<100;i++){
            t1 = new Thread(autoIncreaseDemo);
            t1.start();
            t1.join();
        }

        //Thread.sleep(5000);
        System.out.println("counter : "+counter.getValue());
        System.out.println("count : "+count.hashCode());
        System.out.println("counter1 : "+count1.hashCode());
        System.out.println("atomicInteger : "+atomicInteger.intValue());
    }


}

class Counter{
    private int count;

    public synchronized int getValue(){
        return count;
    }

    public synchronized int inCreaseNum(){
        return count++;
    }
}

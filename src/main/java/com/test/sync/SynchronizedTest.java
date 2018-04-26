package com.test.sync;

/**
 * @author huangchangling on 2017/8/28 0028
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        int cycle = 5;
        Object lock = new Object();

        for (int i = 0;i<cycle;i++){
            new TaskThread(lock).start();
        }
    }


}
class TaskThread extends Thread{

    private Object lock;
    TaskThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        System.out.println("begin---->"+Thread.currentThread().getName());
        synchronized (lock){
            int count =99;
            try {
                while(count % 10 == 0) {
                    lock.wait();
                }
            }
            catch(Exception e){


            }finally{
                lock.notify();
            }
            System.out.println("end---->"+Thread.currentThread().getName() + count-- );
        }
    }
}


package com.test.sync;

/**
 * @author huangchangling on 2017/8/28 0028
 */
public class SyTest {
    public static void main(String []args){

        Object lock = new Object();
        PrintThread a = new PrintThread(lock);
        PrintThread b = new PrintThread(lock);
        PrintThread c = new PrintThread(lock);
        PrintThread d = new PrintThread(lock);
        PrintThread e = new PrintThread(lock);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}



class PrintThread extends Thread{
    private Object lock;
    public PrintThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        System.out.println("-------------  "+this.getName() + lock);
        synchronized (lock) {//进入同步队列,获取到资源就可以执行
            for (int i = 0; i < 100; i++) {
                if (i % 10 == 0 && 0 != i) {
                    try {
                        lock.wait();   //暂时释放资源,进入等待队列,待唤醒后进入同步队列
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        lock.notify();
                    }
                }
                System.out.println(this.getName()+": "+i);
            }
        }
    }

}

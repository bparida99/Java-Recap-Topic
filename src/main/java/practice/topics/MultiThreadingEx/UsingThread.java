package practice.topics.MultiThreadingEx;

import java.util.concurrent.atomic.AtomicInteger;

public class UsingThread extends Thread{
   private static  AtomicInteger x= new AtomicInteger(0);
    @Override
    public void run(){
       for(int i=0;i<10000;i++){
           x.incrementAndGet();
       }
    }

    public static void main(String r[]) throws InterruptedException {
        UsingThread t1 = new UsingThread();
        UsingThread t2 = new UsingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x);

    }
}

package practice.topics.MultiThreadingEx;

import java.util.concurrent.atomic.AtomicInteger;

public class UsingAnonymous {
    private static AtomicInteger x = new AtomicInteger(0);
    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public  void run(){
             for(int i=0;i<100;i++){
                 x.incrementAndGet();
             }
            }
        };
        //Using lamda
        Thread t2  = new Thread(()->{
            for(int i=0;i<100;i++){
                x.incrementAndGet();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x);
    }
}

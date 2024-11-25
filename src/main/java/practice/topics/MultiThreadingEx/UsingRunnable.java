package practice.topics.MultiThreadingEx;

import java.util.concurrent.atomic.AtomicInteger;

public class UsingRunnable implements Runnable{
    private static AtomicInteger x = new AtomicInteger(0);
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            x.incrementAndGet();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        UsingRunnable u = new UsingRunnable();
        Thread t1= new Thread(u);
        t1.start();
        t1.join();
        System.out.println(x);

    }
}

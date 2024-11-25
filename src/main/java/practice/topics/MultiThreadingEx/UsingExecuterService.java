package practice.topics.MultiThreadingEx;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UsingExecuterService {

    private static AtomicInteger x = new AtomicInteger(0);

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable task = ()->{
            for(int i=0;i<100;i++){
                x.incrementAndGet();
            }
        };

        Callable<Integer> task2 = ()->{
            for(int i=0;i<100;i++){
                x.incrementAndGet();
            }
            return x.get();
        };

       // executorService.submit(task);
        executorService.invokeAll(List.of(task2,task2));
        executorService.shutdown();
        System.out.println(x);



    }
}

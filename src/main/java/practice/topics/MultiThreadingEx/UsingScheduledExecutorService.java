package practice.topics.MultiThreadingEx;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UsingScheduledExecutorService {

    private static AtomicInteger x = new AtomicInteger(0);

    public static void main(String args[]) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        // Create a Runnable task
        Runnable task = () -> {
            System.out.println("Task executed at: " + System.currentTimeMillis());
        };

        // Schedule the task to run every 5 seconds with an initial delay of 1 second
        scheduledExecutorService.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
    }
}

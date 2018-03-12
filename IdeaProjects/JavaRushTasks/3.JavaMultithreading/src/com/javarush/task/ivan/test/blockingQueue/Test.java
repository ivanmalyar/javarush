package com.javarush.task.ivan.test.blockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(10);
        queue.put("Запсь №0");
        queue.put("Запсь №0");
        queue.put("Запсь №0");
        queue.put("Запсь №0");
        queue.put("Запсь №0");

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Producer(queue));
        service.submit(new Consumer(queue));

        Thread.sleep(10000);
        service.shutdownNow();




    }
}

package com.javarush.task.ivan.test.blockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 1;
        while (true){
            try {
                queue.put("Запись №" + count);
                count++;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

package com.javarush.task.ivan.test.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(queue.take());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}

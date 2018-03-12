package com.javarush.task.a_test.MyQueue;

public class Producer extends Thread {
    private BlockQueue blockQueue;

    public Producer(BlockQueue<String> blockQueue) {
        this.blockQueue = blockQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                blockQueue.push("string #" + (i+1));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

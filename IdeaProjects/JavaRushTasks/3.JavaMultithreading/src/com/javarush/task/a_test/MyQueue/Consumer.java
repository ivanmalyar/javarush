package com.javarush.task.a_test.MyQueue;

public class Consumer extends Thread {
    private BlockQueue blockQueue;

    public Consumer(BlockQueue<String> blockQueue) {
        this.blockQueue = blockQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++){
            try {
                System.out.println(blockQueue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

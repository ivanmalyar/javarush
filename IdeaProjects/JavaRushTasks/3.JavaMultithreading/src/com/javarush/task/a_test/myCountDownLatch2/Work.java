package com.javarush.task.a_test.myCountDownLatch2;

import java.util.concurrent.CountDownLatch;

public class Work implements Runnable {
    private CountDownLatch latch;

    public Work(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " does work");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

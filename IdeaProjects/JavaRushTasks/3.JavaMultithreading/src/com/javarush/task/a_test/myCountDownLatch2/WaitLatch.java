package com.javarush.task.a_test.myCountDownLatch2;

import java.util.concurrent.CountDownLatch;

public class WaitLatch implements Runnable {
    private CountDownLatch latch;

    public WaitLatch(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println(Thread.currentThread().getName() + " stop waiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

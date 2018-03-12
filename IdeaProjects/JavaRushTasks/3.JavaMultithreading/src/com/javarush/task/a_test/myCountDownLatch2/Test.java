package com.javarush.task.a_test.myCountDownLatch2;

import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new WaitLatch(latch);

        Thread.sleep(1000);
        new Work(latch);
        Thread.sleep(1000);
        new Work(latch);
        Thread.sleep(1000);
        new Work(latch);

    }




}

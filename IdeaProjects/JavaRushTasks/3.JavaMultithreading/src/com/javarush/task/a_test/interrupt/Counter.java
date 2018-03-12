package com.javarush.task.a_test.interrupt;

public class Counter implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(count++);

        }

    }
}

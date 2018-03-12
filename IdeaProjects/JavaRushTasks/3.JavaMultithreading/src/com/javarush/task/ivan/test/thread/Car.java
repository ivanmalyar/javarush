package com.javarush.task.ivan.test.thread;

public class Car implements Runnable {
    private int x;

    public Car(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Test.operationWithBox(x);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

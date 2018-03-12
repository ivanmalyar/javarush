package com.javarush.task.ivan.test.thread_safe;

public class Base {
    private volatile int countBox;

    public Base(int countBox) {
        this.countBox = countBox;
    }

    public synchronized void bringBox(int box){
        try {
            int b1 = box;
            Thread.sleep(500);
            int b2 = countBox;
            Thread.sleep(500);
            int b3 = b1 + b2;
            Thread.sleep(500);
            countBox = b3;
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " привез " + box + " коробок. Всего: " + countBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void takeAway(int box){
        try {
            int b1 = box;
            Thread.sleep(500);
            int b2 = countBox;
            Thread.sleep(500);
            int b3 = b2 - b1;
            Thread.sleep(500);
            countBox = b3;
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " увез " + box + " коробок. Всего: " + countBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}

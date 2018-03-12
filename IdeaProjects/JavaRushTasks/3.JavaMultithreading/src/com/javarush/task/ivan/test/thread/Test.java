package com.javarush.task.ivan.test.thread;

public class Test {

    private volatile static int countBox = 100;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Car(-5), "Auto #1");
        Thread t2 = new Thread(new Car(7), "Auto #2");

        t1.start();
        t2.start();

    }

    public static void operationWithBox(int anyBox){
        synchronized (Thread.class) {
            countBox += anyBox;
            System.out.println(Thread.currentThread().getName() + " привез " + anyBox + " коробок. Всего: " + countBox);
        }
    }





}

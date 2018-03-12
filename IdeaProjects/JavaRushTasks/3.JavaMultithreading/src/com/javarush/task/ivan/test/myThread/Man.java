package com.javarush.task.ivan.test.myThread;

public class Man implements Runnable {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Test.print(name);
        Thread.yield();
        Test.print(name);
    }
}

package com.javarush.task.ivan.test.thread_safe;

public class Truck extends Thread {
    private int capacity;
    private boolean isBring;

    public Truck(int capacity,  boolean isBring, String name) {
        super(name);
        this.capacity = capacity;
        this.isBring = isBring;
    }

    @Override
    public void run() {
        if (isBring)Test.base.bringBox(capacity);
        else Test.base.takeAway(capacity);
    }
}

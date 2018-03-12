package com.javarush.task.task17.task1718.my;

public class Man extends Thread {

    public Man(String name) {
        super(name);
    }

    @Override
    public void run() {
        Women shalava = Women.getInstanceWomen();
        shalava.fuck(this);
    }
}

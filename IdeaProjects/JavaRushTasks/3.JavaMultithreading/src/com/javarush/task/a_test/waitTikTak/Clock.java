package com.javarush.task.a_test.waitTikTak;

public class Clock extends Thread {
    private volatile boolean tikTak = true;

    public boolean isTikTak() {
        return tikTak;
    }

    public void setTikTak(boolean tikTak) {
        this.tikTak = tikTak;
    }

    @Override
    public void run() {
        new Thread(new Tik(this)).start();
        new Thread(new Tak(this)).start();
    }
}

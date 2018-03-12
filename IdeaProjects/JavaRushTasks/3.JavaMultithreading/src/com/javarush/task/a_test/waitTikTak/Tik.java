package com.javarush.task.a_test.waitTikTak;

public class Tik implements Runnable {
    private Clock clock;

    public Tik(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (clock){
                while (clock.isTikTak()){
                    try {
                        clock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("tik");
                clock.setTikTak(true);
                clock.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

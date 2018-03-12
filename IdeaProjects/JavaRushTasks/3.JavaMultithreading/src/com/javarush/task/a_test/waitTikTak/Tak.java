package com.javarush.task.a_test.waitTikTak;

public class Tak implements Runnable {
    private Clock clock;

    public Tak(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (clock){
                while (!clock.isTikTak()){
                    try {
                        clock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("tak");
                clock.setTikTak(false);
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

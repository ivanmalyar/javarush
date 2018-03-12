package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    static Thread thread;
    @Override
    public void run() {
        while (true){
            try {
                System.out.println(thread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
               // e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}

package com.javarush.task.ivan.test.waitNotify;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        synchronized (myThread){
            myThread.wait();
        }


        System.out.println(myThread.count);
    }


    public static class MyThread extends Thread{
        int count = 0;
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++){
                    count += i;
                    if (i > 2) notify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //notify();
            }
        }
    }
}

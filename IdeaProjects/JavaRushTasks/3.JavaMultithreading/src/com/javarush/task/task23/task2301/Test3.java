package com.javarush.task.task23.task2301;

public class Test3 {

    private static Thread thread = new Thread(){
        public void run(){
            while (isInterrupted()){
                try {
                    System.out.println("thread");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }

        }
    };

    public static void main(String[] args) throws InterruptedException {
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }


}

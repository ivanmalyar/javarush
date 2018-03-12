package com.javarush.task.task23.task2301.my.Test;

public class Test extends Thread {

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        Test test2 = new Test();
        test2.start();
    }

    public void run(){
        while (true){
            System.out.println("Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }






}

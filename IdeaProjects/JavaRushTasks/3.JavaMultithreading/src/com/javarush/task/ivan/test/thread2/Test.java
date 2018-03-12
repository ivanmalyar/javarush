package com.javarush.task.ivan.test.thread2;

public class Test extends Thread {
    private String name;
    private static volatile Integer count = 0;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        print(name);
    }

    public static void main(String[] args) {
        Test gena = new Test("Gena");
        Test kolya = new Test("Kolya");
        gena.start();
        kolya.start();
    }

    public static void print(String string){
        synchronized (count) {
            while (count < 100) {
                try {
                    System.out.println(string + " " + count);
                    count++;
                    if(count >20) count.wait();
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }







}

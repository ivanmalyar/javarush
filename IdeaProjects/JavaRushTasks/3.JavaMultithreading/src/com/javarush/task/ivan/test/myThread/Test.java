package com.javarush.task.ivan.test.myThread;

public class Test {
    private String string = "In the Test";

    public static void main(String[] args) {
        Thread gena = new Thread(new Man("Gena"));
        Thread kolya = new Thread(new Man("Kolya"));

        gena.start();
        kolya.start();
    }


    static synchronized void print(String name){
        int count = 0;
        while (count < 3){
            try {
                System.out.println("My name is " + name);
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

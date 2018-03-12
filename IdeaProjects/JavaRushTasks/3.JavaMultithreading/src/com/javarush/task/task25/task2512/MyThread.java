package com.javarush.task.task25.task2512;

public class MyThread extends Thread {
    @Override
    public void run()  {
        //System.out.println("run MyThread");
        throw new RuntimeException("ABC", new RuntimeException("DEF", new RuntimeException("GHI")));
    }
}

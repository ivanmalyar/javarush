package com.javarush.task.task22.task2203.my;

public class myHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println( t.getName() + " : " + e.getMessage() +  " myHandler");
    }
}

package com.javarush.task.task22.task2203.my;

public class Test {
    public static void main(String[] args) {
        int a = 100;
        Thread.setDefaultUncaughtExceptionHandler(new myHandler());


        for (int i = 10; i >= 0; i--) {
            System.out.println(a + " / " + i + " = " + a / i);
        }


    }
}

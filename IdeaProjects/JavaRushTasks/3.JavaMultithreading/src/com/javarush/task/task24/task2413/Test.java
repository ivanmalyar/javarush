package com.javarush.task.task24.task2413;

public class Test {
    public static void main(String[] args) {
        double x = 6;
        double y = 8;

        double x2 = Math.pow(x, 2);
        double y2 = Math.pow(y, 2);
        double d = Math.sqrt(x2 + y2);
        System.out.println(d);
    }
}

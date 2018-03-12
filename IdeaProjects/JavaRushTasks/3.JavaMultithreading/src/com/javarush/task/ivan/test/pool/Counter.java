package com.javarush.task.ivan.test.pool;

public class Counter {
    public Double count(){
        double a = 0;
        for (int i = 0; i < 100000000; i++){
            a = a + Math.atan(i);
        }
        return a;
    }
}

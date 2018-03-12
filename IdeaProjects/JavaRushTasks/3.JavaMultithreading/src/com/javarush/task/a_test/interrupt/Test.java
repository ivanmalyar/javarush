package com.javarush.task.a_test.interrupt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();

        System.out.println(task.get());




    }
}

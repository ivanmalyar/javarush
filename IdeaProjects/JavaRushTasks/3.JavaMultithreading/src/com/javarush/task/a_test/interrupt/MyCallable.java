package com.javarush.task.a_test.interrupt;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "Result string";
    }
}

package com.javarush.task.ivan.test.pool;
import java.util.concurrent.Callable;

public class MyTask implements Callable<String> {
    private static int count;

    public MyTask() {
        count++;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread() + " task #" + count;
    }
}

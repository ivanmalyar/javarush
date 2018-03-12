package com.javarush.task.a_test.waitTask;

public class Test {

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();

        MyExecutor myExecutor = new MyExecutor(taskQueue);
        MyProducer myProducer = new MyProducer(taskQueue);



        myExecutor.start();
        myProducer.start();

    }
}

package com.javarush.task.a_test.MyQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<String> blockQueue = new BlockQueue<String>();
        Producer producer = new Producer(blockQueue);
        Consumer consumer = new Consumer(blockQueue);

        producer.start();
        consumer.start();


    }



}

package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        //1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение,
        // где ключ - счетчик начиная с 1, значение - фраза: "Some text for i" , пример "Some text for 1".
        //2. при возникновении исключения выводить в консоль: "[TREAD_NAME] thread was terminated",
        // пример "[thread-1] thread was terminated".

        int count = 1;
        while (!Thread.currentThread().isInterrupted()){
            try {
                map.put(String.valueOf(count), "Some text for " + count);
                count++;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println( "[" + Thread.currentThread().getName() + "] thread was terminated");
            }
        }

    }
}

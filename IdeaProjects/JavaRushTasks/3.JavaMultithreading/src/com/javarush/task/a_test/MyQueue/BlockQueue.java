package com.javarush.task.a_test.MyQueue;

import java.util.LinkedList;

public class BlockQueue<T> {
    private LinkedList<T> queue = new LinkedList<T>();


    public void push(T t){
        synchronized (queue){
            queue.add(t);
            queue.notifyAll();
        }

    }

    public T poll() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }




            return queue.remove();
        }
    }






}

package com.javarush.task.task25.task2514;

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public synchronized void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {

        YieldRunnable y1 = new YieldRunnable(1);
        YieldRunnable y2 = new YieldRunnable(2);

        Thread t1 = new Thread(y1);
        Thread t2 = new Thread(y2);

        t1.start();
        t2.start();


    }
}

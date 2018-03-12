package com.javarush.task.ivan.test.atom;

public class Test extends Thread {
    volatile static int i;
    static boolean b = true;

    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (Test.class) {
                if(b == true) i++;
                else i--;
                b = !b;
                if (i > 1)System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test1 = new Test();
        Test test2 = new Test();
        test1.start();
        test2.start();
        Thread.sleep(3000);
        test1.interrupt();
        test2.interrupt();
    }
}

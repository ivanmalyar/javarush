package com.javarush.task.task25.task2512;
import java.util.ArrayList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {
    List<Throwable> list = new ArrayList<>();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //После вызова uncaughtException нужно прервать нить, которая бросила исключение.
        //System.out.println(t);
        t.interrupt();
        Throwable ee = e;
        while (true){
            if (ee == null) break;
            list.add(ee);
            ee = ee.getCause();
        }
        for (int i = list.size()-1; i >=0; i--){
            System.out.println(list.get(i));
        }
        //System.out.println(e.getCause().getCause());
        //System.out.println(e.getCause());
        //System.out.println(e);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.setDefaultUncaughtExceptionHandler(new Solution());
        myThread.start();

    }
}

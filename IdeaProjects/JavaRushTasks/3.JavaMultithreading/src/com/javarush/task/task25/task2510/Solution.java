package com.javarush.task.task25.task2510;

public class Solution extends Thread {

    public Solution() {
        //В конструкторе Solution должен устанавливаться свой UncaughtExceptionHandler,
        // который будет перехватывать возникшие ошибки и выводить текст в консоль.
        super.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

                /*if(e instanceof Error) System.out.println("Нельзя дальше работать");
                if(e instanceof Exception) System.out.println("Надо обработать");
                if(e instanceof Throwable) System.out.println("Поживем - увидим");*/

                if(e.getClass().getSimpleName().contains("Throwable")) System.out.println("Поживем - увидим");
                if(e.getClass().getSimpleName().contains("Error")) System.out.println("Нельзя дальше работать");
                if(e.getClass().getSimpleName().contains("Exception")) System.out.println("Надо обработать");
            }
        });
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    @Override
    public void run() {
        System.out.println("run");
    }


}

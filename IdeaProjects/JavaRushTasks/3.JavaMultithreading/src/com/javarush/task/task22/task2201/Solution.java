package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        RuntimeException ex = null;
        if (threadName.equals(FIRST_THREAD_NAME)) ex = new TooShortStringFirstThreadException();
        else if (threadName.equals(SECOND_THREAD_NAME)) ex = new TooShortStringSecondThreadException();
        else ex = new RuntimeException();

        String result2 = null;
        //try {
            if(string == null) throw ex;
            String[] strings = string.split("\\t");
            if(strings.length < 3) throw ex;

            //Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
            String result = string.substring(strings[0].length()+1);
            String[] strings2 = result.split("\\t");
            result2 = result.substring(0, result.length() - strings2[strings2.length-1].length()-1);

        //} catch (Exception e) {
            //e.printStackTrace();
        //}


        return result2;
    }
}

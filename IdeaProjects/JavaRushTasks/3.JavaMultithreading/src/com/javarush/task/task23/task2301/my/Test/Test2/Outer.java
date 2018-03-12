package com.javarush.task.task23.task2301.my.Test.Test2;

public class Outer {
    Inner inner = new Inner();


    public void run(){
        while (true){
            System.out.println("Outer run");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        inner.start();
    }



    public class Inner extends Thread{
        public void run(){
            Outer.this.run();
        }
    }




}

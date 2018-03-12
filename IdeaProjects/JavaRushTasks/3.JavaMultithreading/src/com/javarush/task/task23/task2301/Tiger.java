package com.javarush.task.task23.task2301;

public class Tiger {
    private TigerThread thread = new TigerThread();

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.tigerStart();

    }

    public void tigerRun() {
        while (true){
            System.out.println("Tiger");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void tigerStart(){

        thread.start();
    }

     class TigerThread extends Thread{
        public void run(){
            tigerRun();
        }
    }

}

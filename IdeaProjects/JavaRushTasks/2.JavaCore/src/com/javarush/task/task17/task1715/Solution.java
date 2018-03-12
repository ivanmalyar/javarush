package com.javarush.task.task17.task1715;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public volatile static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;


    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {
        //Логика для Apteka: drugsController должен сделать закупку случайного
        // лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс.
        Random randNumber = new Random();

        @Override
        public void run() {
            while (!isStopped){
                drugsController.buy(getRandomDrug(), Solution.getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }

        }

        /*public  Drug getRandomDrug(){
            //DrugsController.allDrugs.
            Drug[] drugs = new Drug[DrugsController.allDrugs.size()];
            int i = 0;

            for (Drug drug:DrugsController.allDrugs.keySet()) {
                drugs[i] = drug;
                i++;
            }

            int iNumber = randNumber.nextInt(drugs.length);
            return drugs[iNumber];
        }*/
    }

    public static class Person implements Runnable {
        //Логика для Person: drugsController должен сделать
        // продажу случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс.

        @Override
        public void run() {
            while (!isStopped){
                drugsController.sell(getRandomDrug(), Solution.getRandomCount());
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public synchronized static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

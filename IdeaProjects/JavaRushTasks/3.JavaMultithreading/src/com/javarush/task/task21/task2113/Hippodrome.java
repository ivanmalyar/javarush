package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public static void main(String[] args) throws InterruptedException {

        Horse bolivar = new Horse("Bolivar", 3, 0);
        Horse zvezdochka = new Horse("Zvezdochka", 3, 0);
        Horse solomon = new Horse("Solomon", 3, 0);

        horses.add(bolivar);
        horses.add(zvezdochka);
        horses.add(solomon);

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
        
    }
    public void move(){
        for (Horse horse:horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse:horses) {
            horse.print();
        }
        /*System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();*/
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        for (int i = 0; i < horses.size() - 1; i++){
            if(horses.get(i).getDistance() < horses.get(i+1).getDistance()) winner = horses.get(i+1);
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }



}

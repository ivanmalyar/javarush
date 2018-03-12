package com.javarush.task.ivan.test.test;

public class Anon {
    static public int f = 50;
    private static Anon anon = new Anon();

    public static void main(String[] args) {
        Print print = new Print(3, "my text");
        print.print();
        anon.method();
        anon.method2();

    }

    public void method(){
        final String s = "inside method";

        Print print2 = new Print(2, "Anon text"){
            @Override
            public void print() {
                System.out.println(getString() + " " + getI() + s + f);
            }
        };
        print2.print();
    }

    public void method2(){
        Flyable f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("I can fly");
            }
        };
        f.fly();
        printFly(f);

    }

    public static void printFly(Flyable flyable){
        flyable.fly();
    }



}

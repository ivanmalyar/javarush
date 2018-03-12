package com.javarush.task.task24.task2412.test;

public class Human {
    public Human() {
        System.out.println("Human constructor");
    }

    class Dog{
        public Dog(int i) {
            System.out.println("Dog constructor" + i);
        }
    }
}

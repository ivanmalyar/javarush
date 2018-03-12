package com.javarush.task.task24.task2412.test;

public class Test extends Human.Dog {

    public Test(Human human) {
        human.super(10);
    }

    public static void main(String[] args) {
        Human human = new Human();
        Test test = new Test(human);
    }
}

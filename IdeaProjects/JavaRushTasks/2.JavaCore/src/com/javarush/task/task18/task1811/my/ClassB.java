package com.javarush.task.task18.task1811.my;

public class ClassB {
    ClassA original = new ClassA();

    public void printA() {
        original.printA();
    }

    public void printB() {
        original.printB();
    }

    public void printC() {
        original.printC();
    }
}

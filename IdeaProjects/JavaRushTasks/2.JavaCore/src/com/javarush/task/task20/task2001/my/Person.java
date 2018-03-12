package com.javarush.task.task20.task2001.my;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Runnable, Serializable {
    private String name;
    private int age;
    transient Thread runner;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        startThread();
    }

    /*public String getName() {
        return name;
    }*/

    @Override
    public void run() {
        while (true){
            System.out.println("My name is " + name + ", I am " + age);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startThread(){
        runner = new Thread(this);
        runner.start();
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        startThread();
    }


}

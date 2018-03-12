package com.javarush.task.ivan.test.compare;

public class Man implements Comparable<Man> {
    private String name;
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
/*
    @Override
    public int compareTo(Man man) {
        return this.getName().compareTo(man.getName());
    }*/

    @Override
    public int compareTo(Man man) {
        if (this.getAge() > man.getAge()) return 1;
        else if (this.getAge() < man.getAge()) return -1;
        else return 0;
    }
}

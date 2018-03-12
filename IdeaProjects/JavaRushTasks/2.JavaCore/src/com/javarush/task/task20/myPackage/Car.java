package com.javarush.task.task20.myPackage;

import java.io.Serializable;

public class Car implements Serializable {
    private String mark;
    private String model;
    int price;
    int age;

    public Car(String mark, String model, int price, int age) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.age = age;
    }

    @Override
    public String toString() {
        return mark + " " + model + ", price: " + price + "$, age: " + age;
    }
}

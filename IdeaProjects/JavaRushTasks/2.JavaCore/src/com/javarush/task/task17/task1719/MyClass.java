package com.javarush.task.task17.task1719;

public class MyClass implements BeanOne {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                '}';
    }
}

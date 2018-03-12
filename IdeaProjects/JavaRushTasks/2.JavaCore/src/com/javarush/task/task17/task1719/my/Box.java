package com.javarush.task.task17.task1719.my;

public class Box<Type> {
    private Type val;

    public Box(Type val) {
        this.val = val;
    }

    public Type getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "{" + val + "}";
    }
}

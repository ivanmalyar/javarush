package com.javarush.task.task18.task1810.my;

public class CatWrapper extends Cat {
    private Cat original;


    public CatWrapper(Cat cat) {
        super(cat.getName());
        this.original = cat;
    }

    @Override
    public String getName() {
        return "My name is " + original.getName();
    }

    @Override
    public void setName(String name) {
        original.setName(name);
    }
}

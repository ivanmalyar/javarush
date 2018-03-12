package com.javarush.task.ivan.test.test;

public class Print {
    private int i;
    private String string;

    public Print(int i, String string) {
        this.i = i;
        this.string = string;
    }

    public int getI() {
        return i;
    }

    public String getString() {
        return string;
    }

    public void print(){
        for (int j = 0; j < i; j++){
            System.out.println(string);
        }
    }
}

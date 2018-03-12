package com.javarush.task.task23.task2310;

public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public void printInformation(){
        this.getInformation();
    }

    private void getInformation(){
        System.out.println(name);
    }

    public static void main(String[] args) {

        Test2 test2 = new Test2("test #2");
        test2.printInformation();


    }
}

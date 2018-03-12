package com.javarush.task.task23.task2301.my.Test.Test3;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Inner inner = test.new Inner();

        Car car = new Car(test);

    }
    public class Inner{}
}

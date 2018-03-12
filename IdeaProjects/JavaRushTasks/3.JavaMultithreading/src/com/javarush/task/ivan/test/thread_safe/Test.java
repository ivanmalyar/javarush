package com.javarush.task.ivan.test.thread_safe;

public class Test {
    public static Base base = new Base(100);

    public static void main(String[] args) {
        Thread truck1 = new Truck(5, false, "truck1");
        Thread truck2 = new Truck(5, true, "truck2");

        truck1.start();
        truck2.start();
    }
}

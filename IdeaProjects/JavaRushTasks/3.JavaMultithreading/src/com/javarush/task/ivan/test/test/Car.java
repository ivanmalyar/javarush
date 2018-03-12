package com.javarush.task.ivan.test.test;
import java.util.ArrayList;

public class Car {
    public static void main(String[] args) {
        Car car = new Car();
        ArrayList<Car> list = car.createList();

        for (Car c:list) {
            System.out.println(c);
        }

    }

    public ArrayList<Car> createList(){
        final int i = 5;
        ArrayList<Car> result = new ArrayList<>();

        for (int j = 0; j < i; j++){
            result.add(new Car(){
                int number = i;
                int couunt;
                {
                    couunt = 9;
                }

                @Override
                public String toString() {
                    return "$classname{" +
                            "number=" + number +
                            ", couunt=" + couunt +
                            '}';
                }
            });
        }
        return result;
    }




}

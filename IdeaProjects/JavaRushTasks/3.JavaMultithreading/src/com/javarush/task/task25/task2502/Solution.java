package com.javarush.task.task25.task2502;

import java.util.*;

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();
            String[] strings = loadWheelNamesFromDB();

            if (strings.length != 4) throw new Exception();

            wheels.add(Wheel.valueOf(strings[0]));
            wheels.add(Wheel.valueOf(strings[1]));
            wheels.add(Wheel.valueOf(strings[2]));
            wheels.add(Wheel.valueOf(strings[3]));


        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        //Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
        Car car = new Car();
    }
}

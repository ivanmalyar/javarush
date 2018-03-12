package com.javarush.task.ivan.test.clone;

import java.io.Serializable;

public class House implements Serializable {
    private int countFloor;

    public House(int countFloor) {
        this.countFloor = countFloor;
    }

    public int getCountFloor() {
        return countFloor;
    }
}

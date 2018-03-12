package com.javarush.task.ivan.test.myEnum;

public class Test {
    public static void main(String[] args) {
        Direction direction = Direction.LEFT;
        direction = Direction.UP;

        System.out.println(direction.ordinal());

        System.out.println(Direction.values());

    }
}

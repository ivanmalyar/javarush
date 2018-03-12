package com.javarush.task.task19.task1910.my;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyOut {
    public static void main(String[] args) {

        PrintStream consoleStream =  System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        System.out.println("Hi, girls!");

        System.setOut(consoleStream);

        System.out.println("Hi, girls!");








    }
}

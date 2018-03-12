package com.javarush.task.task18.task1815.my;

import java.io.*;

public class MyTest {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("d://a.txt");

        /*while (fileReader.ready()){
            System.out.println(fileReader.read());
        }*/


        System.out.println(fileReader.read());
        System.out.println(fileReader.read());
        System.out.println(fileReader.read());









    }
}

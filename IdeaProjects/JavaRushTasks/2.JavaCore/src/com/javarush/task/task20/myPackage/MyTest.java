package com.javarush.task.task20.myPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);


        Car loadCar = (Car) ois.readObject();
        System.out.println(loadCar);
    }
}

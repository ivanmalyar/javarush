package com.javarush.task.task20.myPackage;

import java.io.*;

public class MySerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car toyota = new Car("Toyota", "Corolla", 2000, 10);

        System.out.println(toyota);

        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(toyota);
        fileOutputStream.close();
        oos.close();


        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);


        Car loadCar = (Car) ois.readObject();

        System.out.println(loadCar);



    }

}

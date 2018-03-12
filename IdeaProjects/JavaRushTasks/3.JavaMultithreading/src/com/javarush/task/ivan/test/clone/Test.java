package com.javarush.task.ivan.test.clone;

import org.omg.CORBA.portable.OutputStream;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House(5);
        System.out.println(house);
        System.out.println(house.getCountFloor());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(house);
        objectOutputStream.close();

        byte[] buffer = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        House copyHouse = (House) objectInputStream.readObject();

        System.out.println(copyHouse);
        System.out.println(copyHouse.getCountFloor());












    }
}

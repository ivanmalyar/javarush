package com.javarush.task.task20.task2001.my;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MySave {
    public static void main(String[] args) throws IOException {
        Person bob = new Person("Bob", 30);

        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(bob);
        fileOutputStream.close();
        oos.close();





    }
}

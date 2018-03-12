package com.javarush.task.task20.task2001.my;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyLoad {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Person loadedPerson = (Person) ois.readObject();
        fileInputStream.close();
        ois.close();

        //System.out.println(loadedPerson.getName());
    }
}

package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));


        Solution savedObject = new Solution(-30);
        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        try {
            oos.writeObject(savedObject);
        } catch (IOException e) {

        }
        fileOutputStream.close();
        oos.close();

        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution loadedObject = null;
        try {
            loadedObject = (Solution) ois.readObject();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        fileInputStream.close();
        ois.close();

        System.out.println(loadedObject);



    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

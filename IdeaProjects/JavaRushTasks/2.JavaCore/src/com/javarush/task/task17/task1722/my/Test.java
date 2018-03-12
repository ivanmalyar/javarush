package com.javarush.task.task17.task1722.my;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("d://egor_cat_big.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d://123.jpg");

        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }












    }
}

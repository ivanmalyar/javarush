package com.javarush.task.task18.task1805.my;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("d://a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d://b.jpg");


        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            fileOutputStream.write(data );
            fileOutputStream.write(data );
        }




    }
}

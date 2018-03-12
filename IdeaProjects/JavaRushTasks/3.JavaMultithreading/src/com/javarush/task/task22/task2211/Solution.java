package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

public class Solution {
    public static Charset win1251 = Charset.forName("Windows-1251");
    public static Charset utf8 = Charset.forName("UTF-8");
    public static void main(String[] args) throws IOException {

        String fileName1 = args[0];
        String fileName2 = args[1];

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        byte buffer[]   = new byte[1000];
        int  bufferSize = 1000;

        while (inputStream.available() > 0){
            if (inputStream.available() < 1000) bufferSize = inputStream.available();
            inputStream.read(buffer, 0, bufferSize);
            String s = new String(buffer, win1251);
            buffer = s.getBytes(utf8);
            outputStream.write(buffer);
        }

        inputStream.close();
        outputStream.close();





    }
}

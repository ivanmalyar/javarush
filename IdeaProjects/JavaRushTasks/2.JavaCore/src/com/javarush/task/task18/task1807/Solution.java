package com.javarush.task.task18.task1807;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = "d://a.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int searchedChar = 0x002C;
        int countChar = 0;

        while (fileInputStream.available() > 0){
            if(fileInputStream.read() == searchedChar) countChar++;
        }

        System.out.println(countChar);
        fileInputStream.close();

    }
}

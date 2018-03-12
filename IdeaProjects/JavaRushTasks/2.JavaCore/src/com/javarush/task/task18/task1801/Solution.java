package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Программа должна считывать имя файла с консоли.
        //2. Для чтения из файла используй поток FileInputStream.
        //3. В консоль должен выводиться максимальный байт, считанный из файла.
        //4. Поток чтения из файла должен быть закрыт.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        int maxByte = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (data > maxByte) maxByte = data;
        }
        fileInputStream.close();

        System.out.println(maxByte);


    }
}

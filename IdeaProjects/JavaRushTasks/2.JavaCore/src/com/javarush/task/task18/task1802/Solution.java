package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Программа должна считывать имя файла с консоли.
        //2. Для чтения из файла используй поток FileInputStream.
        //3. В консоль должен выводиться минимальный байт, считанный из файла.
        //4. Поток чтения из файла должен быть закрыт.


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        int min = 255;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (data < min) min = data;
        }
        fileInputStream.close();

        System.out.println(min);








    }
}

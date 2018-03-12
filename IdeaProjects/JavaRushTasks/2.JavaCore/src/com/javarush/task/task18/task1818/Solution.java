package com.javarush.task.task18.task1818;
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Считать с консоли 3 имени файла.
        //Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
        //Закрыть потоки.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName1 = "d://a.txt";
        //String fileName2 = "d://b.txt";
        //String fileName3 = "d://c.txt";


        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);

        byte[] bytes2 = new byte[fileInputStream2.available()];
        byte[] bytes3 = new byte[fileInputStream3.available()];

        fileInputStream2.read(bytes2);
        fileInputStream3.read(bytes3);

        fileOutputStream.write(bytes2);
        fileOutputStream.write(bytes3);

        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream.close();

    }
}

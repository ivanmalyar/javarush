package com.javarush.task.task18.task1819;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        byte[] bytes1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(bytes1);
        fileInputStream1.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);

        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        byte[] bytes2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(bytes2);
        fileInputStream2.close();

        fileOutputStream.write(bytes2);
        fileOutputStream.write(bytes1);
        fileOutputStream.close();

    }
}

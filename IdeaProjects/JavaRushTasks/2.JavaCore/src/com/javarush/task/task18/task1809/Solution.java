package com.javarush.task.task18.task1809;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        //String fileName1 = "d://a.txt";
        //String fileName2 = "d://b.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        byte[] bytes = new byte[fileInputStream.available()];

        while (fileInputStream.available() > 0){
            fileInputStream.read(bytes);
        }

        for (int i = bytes.length - 1; i >= 0; i--){
            fileOutputStream.write(bytes[i]);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}

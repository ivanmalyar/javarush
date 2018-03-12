package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String param = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            int ii = 0;

            if (param.equals("-e")) ii = encryption(i);
            if (param.equals("-d")) ii = decryption(i);

            fileOutputStream.write(ii);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }



    public static int encryption(int i){
        return i + 1;
    }
    public static int decryption(int i){
        return i - 1;
    }

}

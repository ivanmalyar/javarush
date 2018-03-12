package com.javarush.task.task19.task1907;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        StringBuilder stringBuilder = new StringBuilder();

        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready()){
            stringBuilder.append((char)fileReader.read());
        }
        fileReader.close();
        String string = stringBuilder.toString();
        String[] strings = string.split("\\W");
        int count = 0;
        for (String s:strings) {
            if (s.equals("world")) count++;
        }
        System.out.println(count);

    }
}

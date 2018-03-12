package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName1 = "d://a.txt";
        //String fileName2 = "d://b.txt";

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        List<String> list = new ArrayList<>();

        while (bufferedFileReader.ready()){
            String string = bufferedFileReader.readLine();
            String[] strings = string.split(" ");
            for (String s:strings) {
                if (s.matches("[0-9]*")) list.add(s);
            }
        }
        bufferedFileReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        for (String s:list) {
            bufferedWriter.write(s + " ");
        }
        bufferedWriter.close();




































    }
}

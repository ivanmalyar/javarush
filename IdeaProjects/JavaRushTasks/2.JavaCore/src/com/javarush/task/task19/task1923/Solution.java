package com.javarush.task.task19.task1923;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        while (bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            for (String string:strings) {
                if (string.replaceAll("[0-9]*", "").length() < string.length()){
                    bufferedWriter.write(string + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();



    }
}

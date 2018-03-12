package com.javarush.task.task19.task1910;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName1 = "d://a.txt";
        //String fileName2 = "d://b.txt";

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        while (bufferedFileReader.ready()){
            String s = bufferedFileReader.readLine();
            String ss = s.replaceAll("\\p{Punct}", "");
            bufferedWriter.write(ss);
        }


        bufferedFileReader.close();
        bufferedWriter.close();









    }
}

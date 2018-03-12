package com.javarush.task.task19.task1909;
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
            bufferedWriter.write(bufferedFileReader.readLine().replaceAll("\\.", "!") + "\r\n");
        }
        bufferedFileReader.close();
        bufferedWriter.close();








    }
}

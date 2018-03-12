package com.javarush.task.task19.task1926;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName = "d://a.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()){
            char[] chars = fileReader.readLine().toCharArray();
            for (int i = chars.length-1; i >= 0; i--){
                System.out.print(chars[i]);
            }
            System.out.println();
        }
        fileReader.close();




    }
}

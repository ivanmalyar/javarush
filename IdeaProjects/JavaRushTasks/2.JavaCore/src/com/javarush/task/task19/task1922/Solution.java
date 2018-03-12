package com.javarush.task.task19.task1922;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        while (bufferedFileReader.ready()){
            String s = bufferedFileReader.readLine();
            String[] strings = s.split(" ");
            int count = 0;      //счетчик

            for (String string:strings) {
                if (isEqual(string)) count++;
            }

            if (count == 2) System.out.println(s);
        }
        bufferedFileReader.close();
    }

    private static boolean isEqual(String s){
        for (String word:words) {
            if (s.equals(word)) return true;
        }
        return false;
    }



}

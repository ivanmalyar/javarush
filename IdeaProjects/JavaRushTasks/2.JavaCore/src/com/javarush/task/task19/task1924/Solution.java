package com.javarush.task.task19.task1924;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName = "d://a.txt";
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        while (bufferedFileReader.ready()){
            String[] strings = bufferedFileReader.readLine().split(" ");

            for (String s:strings) {
                String sss = isMyInt(s);
                if (!sss.equals("0")) System.out.print(sss + " ");
                else System.out.print(s + " ");
            }
            System.out.println();
        }
        bufferedFileReader.close();
    }

    private static String isMyInt(String s){
        for (Map.Entry<Integer, String> pair:map.entrySet()) {
            if (s.equals(pair.getKey().toString())){
                return pair.getValue();
            }
        }
        return "0";
    }




}

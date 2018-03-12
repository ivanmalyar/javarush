package com.javarush.task.task19.task1920;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static TreeMap<String, Double> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            String[] s = bufferedReader.readLine().split(" ");
            isUniq(s[0], Double.parseDouble(s[1]));
        }
        bufferedReader.close();

        double max = 0;
        for (Map.Entry<String, Double> pair:map.entrySet()) {
            if (pair.getValue() > max) max = pair.getValue();
        }
        for (Map.Entry<String, Double> pair:map.entrySet()) {
            if (pair.getValue() == max) System.out.println(pair.getKey());
        }

    }

    private static void isUniq(String k, double v){
        for (Map.Entry<String, Double> pair:map.entrySet()) {
            if (pair.getKey().equals(k)){
                map.put(k, v + pair.getValue());
                return;
            }
        }
        map.put(k, v);

    }
}

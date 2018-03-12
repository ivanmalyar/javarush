package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> integers = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        //String fileName = "d://a.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            integers.add(data);
        }
        fileInputStream.close();

        int[] counts = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++){
            counts[i] = 0;
        }

        for (int i = 0; i < integers.size(); i++) {
            int ii = integers.get(i);

            for (int j = 0; j < integers.size(); j++){
                if (ii == integers.get(j)){
                    counts[j] = counts[j] + 1;
                }
            }

        }

        //ищем минимальное значение counts
        int minCount = counts[0];
        for (int i = 0; i < counts.length; i++){
            if (counts[i] < minCount) minCount = counts[i];
        }

        // список максимальных байтов
        Set<Integer> minBytes = new LinkedHashSet<>();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == minCount){
                minBytes.add(integers.get(i));
            }
        }

        for (Integer i:minBytes) {
            System.out.print(i + " ");
        }



//-------------------------------
        /*System.out.println();
        System.out.println(integers);
        for (int i = 0; i < counts.length; i++){
            System.out.print(counts[i] + " ");
        }*/




    }
}

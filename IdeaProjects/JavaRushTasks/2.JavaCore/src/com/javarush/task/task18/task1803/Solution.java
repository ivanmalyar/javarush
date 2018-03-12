package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* 
Самые частые байты
*/

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
        //ищем максимальное значение counts
        int maxCount = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] > maxCount) maxCount = i;
        }

        // список максимальных байтов
        Set<Integer> maxBytes = new LinkedHashSet<>();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount){
                maxBytes.add(integers.get(i));
            }
        }

        for (Integer i:maxBytes) {
            System.out.print(i + " ");
        }

        fileInputStream.close();
    }
}

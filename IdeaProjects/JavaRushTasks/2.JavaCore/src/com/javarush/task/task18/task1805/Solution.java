package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        //String fileName = "d://a.txt";

        Set<Integer> integerSet = new HashSet<>();

        FileInputStream fileInputStream = new  FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            integerSet.add(data);
        }
        fileInputStream.close();

        int[] ints = new int[integerSet.size()];

        int id = 0;
        for (Integer i: integerSet) {
            ints[id] = i;
            id++;
        }

        Arrays.sort(ints);
        for (int i:ints) {
            System.out.print(i + " ");
        }

    }
}

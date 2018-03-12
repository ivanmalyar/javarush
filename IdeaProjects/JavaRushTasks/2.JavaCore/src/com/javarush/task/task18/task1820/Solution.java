package com.javarush.task.task18.task1820;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        StringBuilder stringBuilder = new StringBuilder();

        while (reader.ready()){
            stringBuilder.append(reader.readLine());
        }
        reader.close();

        String string = stringBuilder.toString().trim();

        String[] strings = string.split(" ");
        int[] ints = new int[strings.length];

        for (int j = 0; j < strings.length; j++){

            double d = Double.parseDouble(strings[j]);
            int i = (int) Math.round(d);
            ints[j] = i;
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));

        for (int i = 0; i < ints.length; i++){
            bufferedWriter.write(ints[i] + " ");
            //bufferedWriter.write(" ");
        }

        bufferedWriter.close();





















    }
}

package com.javarush.task.task18.task1824;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //FileInputStream fileInputStream = null;
        String fileName = "";
        while (true){
            fileName = bufferedReader.readLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                bufferedReader.close();
                break;
            }
        }
    }
}

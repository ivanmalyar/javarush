package com.javarush.task.task19.task1906;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName1 = "d://a.txt";
        //String fileName2 = "d://b.txt";

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        while (fileReader.ready()){
            fileReader.read();
            fileWriter.write(fileReader.read());
        }

        /*FileWriter fileWriter1 = new FileWriter("d://a.txt");
        fileWriter1.write("абвгде");
        fileWriter1.close();*/

        fileReader.close();
        fileWriter.close();







    }
}

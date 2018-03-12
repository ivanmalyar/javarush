package com.javarush.task.task18.task1808;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName1 = bufferedReader.readLine();
        //String fileName2 = bufferedReader.readLine();
        //String fileName3 = bufferedReader.readLine();
        //bufferedReader.close();
        String fileName1 = "d://a.txt";
        String fileName2 = "d://b.txt";
        String fileName3 = "d://c.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);

        int countByte =  fileInputStream.available();
        int secondCount = countByte/2;
        int firstCount = countByte - secondCount;
        byte[] bytes = new byte[countByte];


        while (fileInputStream.available()>0){
            fileInputStream.read(bytes);
            fileOutputStream1.write(bytes, 0, firstCount);
            fileOutputStream2.write(bytes, firstCount, secondCount);

        }







        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}

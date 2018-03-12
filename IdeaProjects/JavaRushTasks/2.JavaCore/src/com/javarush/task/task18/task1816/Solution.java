package com.javarush.task.task18.task1816;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuffer stringBuffer = new StringBuffer();


        while (bufferedReader.ready()){
            stringBuffer.append(bufferedReader.readLine());
        }
        String string = stringBuffer.toString();
        int count = 0;

        fileInputStream.close();
        bufferedReader.close();

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);

            if (((c >= 'a')&&(c <= 'z')) || ((c >= 'A')&&(c <= 'Z'))){
                count++;
            }
        }
        System.out.println(count);



    }
}

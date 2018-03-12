package com.javarush.task.task18.task1822;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String file = bufferedReader.readLine();
        //bufferedReader.close();
        String file = "d://a.txt";

        BufferedReader bReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();

        while (bReader.ready()){
            stringBuilder.append(bReader.readLine());
        }
        bReader.close();

        String text = stringBuilder.toString();

        String pattern = args[0] + " [A-Za-z0-9 ]*\\.[0-9]* [0-9]*";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        if(m.find()){
           String data =  m.group(0);
            System.out.println(data);
        }






















    }
}

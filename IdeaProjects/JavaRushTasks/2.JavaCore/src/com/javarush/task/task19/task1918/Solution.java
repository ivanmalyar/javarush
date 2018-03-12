package com.javarush.task.task19.task1918;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static String tag;
    public static int lengthTag;
    public static int lengthStr;
    public static List<Integer> listStart = new ArrayList<>();
    public static List<Integer> listFinish = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tag = args[0];
        lengthTag = tag.length();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName = "d://a.html";

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()){
            stringBuilder.append(fileReader.readLine());
        }
        fileReader.close();
        String string = stringBuilder.toString();
        lengthStr = string.length();

        for (int i = 0; i < lengthStr - (lengthTag+1); i++){
            String s = string.substring(i);
            isStart(s, i);
            isFinish(s, i);
        }

        for (Integer i:listStart) {
            int end = Poisk(i);
            System.out.println(string.substring(i, end + 3 + lengthTag));
        }

    }

    private static void isStart(String s, int i){
        if(s.substring(0,lengthTag+1).equals("<" + tag)){
            listStart.add(i);
        }
    }

    private static void isFinish(String s, int i){
        if(s.substring(0,lengthTag+2).equals("</" + tag)){
            listFinish.add(i);
        }
    }

    private static boolean isStartList(int i){
        for (Integer integer:listStart) {
            if (i == integer) return true;
        }
        return false;
    }

    private static boolean isFinishList(int i){
        for (Integer integer:listFinish) {
            if (i == integer) return true;
        }
        return false;
    }

    private static int Poisk(int i){
        int count = 0;
        for (int j = i + 1; j < lengthStr; j++){
            if(isStartList(j)) count++;
            if(isFinishList(j) && count==0){
                return j;
            }
            if(isFinishList(j)) count--;
        }
        return lengthStr;
    }




}

package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("abc55tyu55hjk", "5");
        for (String string:strings){
            System.out.println(string);
        }
    }

    public static String [] getTokens(String query, String delimiter) {
        List<String> list = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()){
            list.add(stringTokenizer.nextToken());
        }
        return list.toArray(new String[list.size()]);
    }
}

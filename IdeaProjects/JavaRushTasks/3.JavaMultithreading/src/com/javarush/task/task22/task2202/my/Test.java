package com.javarush.task.task22.task2202.my;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] strings = {"sdfg", "hgdf", "qwe"};
        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }

        List<String> list = new ArrayList<>();
        list.add("sdfgsdsdfg");
        list.add("tyu");
        list.add("erth");
        Collections.sort(list);
        for (String s:list) {
            System.out.println(s);
        }






    }
}

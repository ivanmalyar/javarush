package com.javarush.task.task22.task2203;

public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException {
        String result = null;


        try {
            String[] strings = string.split("\\t");
            if(strings.length < 3) throw new TooShortStringException();
            result = strings[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }


        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}

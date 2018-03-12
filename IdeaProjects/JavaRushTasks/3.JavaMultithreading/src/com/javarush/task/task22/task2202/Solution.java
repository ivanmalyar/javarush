package com.javarush.task.task22.task2202;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        String result = null;
        try {
            String[] strings = string.split(" ");
            result = strings[1] + " " + strings[2] + " " + strings[3] + " " + strings[4];
        } catch (Exception e) {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

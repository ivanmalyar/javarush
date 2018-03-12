package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        System.out.println(checkTelNumber("(050)1234567"));
    }

    public static boolean checkTelNumber(String telNumber) {

        if(telNumber == null) return false;
        return Pattern.compile("(\\+\\d{2})?((\\(\\d{3}\\))|(\\d{3}))\\d{3}-?\\d{2}-?\\d{2}").matcher(telNumber).matches();







/*
        if(telNumber.split("-").length > 3) return false;   //3) может содержать 0-2 знаков '-', которые не могут идти подряд
        if(telNumber.matches(".*\\D$")) return false;       //7) номер заканчивается на цифру
        if(!telNumber.matches("[0-9\\+\\-\\(\\)]*")) return false; //6) номер не содержит букв

        String[] strings = telNumber.split("[\\(\\)]{1}");
        if(strings.length > 3) return false;    //4) может содержать 1 пару скобок '(' и ')'
        if(telNumber.split("\\(").length > 2) return false;
        if(telNumber.split("\\)").length > 2) return false;

        if(strings.length == 2) return false;
        if(strings.length  == 3){
            if (strings[0].split("-").length > 1) return false; //, причем если она есть, то она расположена левее знаков '-'
            if (strings[1].split("-").length > 1) return false;
            if(telNumber.split("\\)")[1].split("\\(").length > 1) return false;
            if (strings[1].length() != 3) return false; //5) скобки внутри содержат четко 3 цифры
        }

        if(telNumber.matches("\\+[0-9]{12}")) return true;  //1) если номер начинается с '+', то он содержит 12 цифр
        String s = telNumber.replaceAll("-", "");
        if(s.matches("\\+[0-9]{12}")) return true;
        if(s.matches("\\+\\d\\d\\(\\d\\d\\d\\)[0-9]{7}")) return true;

        if(telNumber.matches("^[0-9\\(].*")){   //2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
            String s2 = telNumber.replaceAll("[\\-\\(\\)]", "");
            if (s2.matches("[0-9]{10}")) return true;
        }*/

        //return false;
    }
}

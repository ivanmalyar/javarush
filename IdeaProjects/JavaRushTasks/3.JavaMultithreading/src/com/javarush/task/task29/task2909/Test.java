package com.javarush.task.task29.task2909;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date date1 = format.parse("10 12 1984");
        Date date2 = format.parse("10 12 2000");


        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.compareTo(date2));

    }
}

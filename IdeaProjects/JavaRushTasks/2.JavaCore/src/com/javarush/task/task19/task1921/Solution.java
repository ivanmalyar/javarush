package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {


        String fileName = args[0];  // имя файла
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));  //ридер
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            String n = s.replaceAll("\\d", "").trim();
            String d = s.replaceAll(n, "").trim();

            SimpleDateFormat ft = new SimpleDateFormat ("dd MM yyyy"); //получаем дату из строки
            Date parsingDate = ft.parse(d);

            PEOPLE.add(new Person(n, parsingDate));

        }
        bufferedReader.close();     //закрываем поток


    }
}

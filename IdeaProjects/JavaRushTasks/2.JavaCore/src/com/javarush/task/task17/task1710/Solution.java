package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        if(args[0].equals("c")) create(args[1], args[2], args[3]);
        else if (args[0].equals("u")) update(args[1], args[2], args[3], args[4]);
        else if (args[0].equals("d")) delete(args[1]);
        else if(args[0].equals("i")) print(args[1]);

        System.out.println(allPeople);

    }

    public static void create(String name, String sex, String date) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        Date d = ft.parse(date);

        if(sex.equals("м")) allPeople.add(Person.createMale(name, d));
        if(sex.equals("ж")) allPeople.add(Person.createFemale(name, d));
        System.out.println(allPeople.size()-1);

        //При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами
        // в конец списка allPeople, и выводить id (index) на экран.

    }

    public static void update(String id, String name, String sex, String date) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        Date d = ft.parse(date);
        int index = Integer.parseInt(id);

        if(sex.equals("м")) allPeople.set(index, Person.createMale(name, d));
        if(sex.equals("ж")) allPeople.set(index, Person.createFemale(name, d));
    }

    public static void delete(String id){
        int index = Integer.parseInt(id);
        Person nullPerson = Person.createMale(null, null);
        nullPerson.setSex(null);
        allPeople.set(index, nullPerson);
    }

    public static void print(String id){
        //выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        //id соответствует индексу в списке
        int index = Integer.parseInt(id);
        System.out.println(allPeople.get(index));


    }






}

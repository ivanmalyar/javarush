package com.javarush.task.task19.task1919;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class GGG {
    private  static List<String> stringList = new ArrayList<>();
    private  static List<Person> people = new ArrayList<>();
    private  static TreeSet<Person> uniqPeople = new TreeSet<>();

    public static void main(String[] args) throws IOException {

       /* String fileName = args[0];

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            stringList.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        for (String s:stringList) {
            String[] strings = s.split(" ");
            people.add(new Person(strings[0], Double.parseDouble(strings[1])));
        }

        for (Person p:people) {
            if (isUniq(p)) {
                uniqPeople.add(p);
            }
        }

        for (Person p:uniqPeople) {
            System.out.println(p.getName() + " " + p.getSalary());
        }*/
    }

    private static boolean isUniq(Person u){
        /*String name = u.getName();

        for (Person p: uniqPeople) {
            if (p.getName().equals(name)) {
                p.setSalary(p.getSalary() + u.getSalary());
                return false;
            }
        }*/
        return true;
    }
}

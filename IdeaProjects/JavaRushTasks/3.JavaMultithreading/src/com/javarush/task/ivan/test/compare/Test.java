package com.javarush.task.ivan.test.compare;
import java.util.*;

public class Test {
    public static Set<Man> mans = new TreeSet<>();
    public static List<Man> manList = new ArrayList<>();

    public static void main(String[] args) {

        mans.add(new Man("Bob", 25));
        mans.add(new Man("Mary", 19));
        mans.add(new Man("John", 30));

        for (Man man:mans) {
            System.out.println(man);
        }
        System.out.println("--------------");

        manList.add(new Man("Bob", 25));
        manList.add(new Man("Mary", 19));
        manList.add(new Man("John", 30));

        manList.sort((o1, o2) -> o1.getAge() - o2.getAge());

        for (Man man:manList) {
            System.out.println(man);
        }



    }
}

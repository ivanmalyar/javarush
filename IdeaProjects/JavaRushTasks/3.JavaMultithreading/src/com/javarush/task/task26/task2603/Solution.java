package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static List<Man> men = new ArrayList<>();

    public static void main(String[] args) {
        men.add(new Man("Bob", 25, true));
        men.add(new Man("Tom", 42, true));
        men.add(new Man("Barbara", 19, false));

        Comparator[] comparators = {new MyComp1()};
        Collections.sort(men, new CustomizedComparator<>(comparators));



        for (Man man:men) {
            System.out.println(man);
        }

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;
        //Убедись, что класс CustomizedComparator содержит конструктор с параметром Comparator<T>....

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            if (comparators == null) return 0;
            for (Comparator c:comparators) {
                int result = c.compare(o1, o2);
                if (result != 0) return result;
            }
            return 0;
        }


    }




}

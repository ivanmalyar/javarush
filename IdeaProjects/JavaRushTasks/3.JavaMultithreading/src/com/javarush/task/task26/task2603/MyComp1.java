package com.javarush.task.task26.task2603;
import java.util.Comparator;

public class MyComp1<T> implements Comparator<Man> {

    @Override
    public int compare(Man o1, Man o2) {
        return o1.getAge() - o2.getAge();
    }
}

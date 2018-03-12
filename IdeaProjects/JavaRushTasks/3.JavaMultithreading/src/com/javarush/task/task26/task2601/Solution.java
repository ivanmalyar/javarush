package com.javarush.task.task26.task2601;

import java.util.*;

public class Solution {
    public static Integer[] integers = new Integer[5];

    public static void main(String[] args) {
        integers[0] = 13;
        integers[1] = 8;
        integers[2] = 15;
        integers[3] = 5;
        integers[4] = 17;

        Integer[] sortIntegers = sort(integers);


    }
    public static int getMediana(Integer[] integers){
        Arrays.sort(integers);
        if (integers.length %2 != 0) {
            return integers[(integers.length-1)/2];
        }else{
            double a = integers[(integers.length)/2 - 1];
            double b = integers[(integers.length)/2];
            return (int)(a + b)/2;
        }
    }

    public static Integer[] sort(Integer[] array) {
        int mediana = getMediana(array);         //находим медиану

        List<Integer> list = new ArrayList<>();  //создаем список, добавляем в него весь массив
        Collections.addAll(list, array);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return (Math.abs(mediana - i1)) - (Math.abs(mediana - i2));
            }
        }.thenComparing(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        }));

        for (int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }
}

package com.javarush.task.task22.task2208.my;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(recursion(157));
    }

    public static String recursion(int n){
        if(n < 10) return String.valueOf(n);
        return recursion(n/10) + " " +  n%10;
    }

    //Дано натуральное число N. Выведите все его цифры по одной,
    // в обычном порядке, разделяя их пробелами или новыми строками.
}

package com.javarush.task.task22.task2208.my;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(recursion(7988));
    }
    public static String recursion(int n){
        if (n < 10) return String.valueOf(n);

            return n%10 + " " + recursion(n/10);
    }
    //Дано натуральное число N. Выведите все его цифры по одной,
    // в обратном порядке, разделяя их пробелами или новыми строками.
}

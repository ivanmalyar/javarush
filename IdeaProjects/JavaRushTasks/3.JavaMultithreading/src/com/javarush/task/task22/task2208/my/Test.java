package com.javarush.task.task22.task2208.my;

public class Test {
    public static void main(String[] args) {
        System.out.println(recursion(5)); // вызов рекурсивной функции
        System.out.println(printInts(6));

    }

    public static int recursion(int n) {
        if (n == 1) { return 1; }
        // Шаг рекурсии / рекурсивное условие
        return recursion(n - 1) * n;
    }

    public static String printInts(int n){
        if(n == 1){ return "1"; }
        return  printInts(n - 1) + " " + n;
    }




}

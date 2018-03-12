package com.javarush.task.task22.task2208.my;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(recursion(7, 7));
    }
    public static String recursion(int n, int i){
        if (i == 1) return "YES";
        if(n%(i-1) > 0){
            recursion(n, i-1);
        }
        return "NO";
    }

    //Дано натуральное число n>1. Проверьте, является ли оно простым.
    // Программа должна вывести слово YES, если число простое и NO,
    // если число составное. Алгоритм должен иметь сложность O(logn).
}

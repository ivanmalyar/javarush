package com.javarush.task.task22.task2208.my;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(recursion(794));
    }

    public static int recursion(int i) {
        if(i == 0) return 0;
        return i%10 + recursion(i/10);
    }

    //Дано натуральное число N. Вычислите сумму его цифр.
    //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
}

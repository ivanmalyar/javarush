package com.javarush.task.task22.task2208.my;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(printInts(12, 8));
    }

    public static String printInts(int a, int b){
        if(a < b){
            if(b == a) return String.valueOf(a);
            return printInts(a, b - 1) + " " + b;
        }else{
            if(b == a) return String.valueOf(b);
            return a + " " + printInts(a - 1, b);
        }
    }



    //Даны два целых числа A и В (каждое в отдельной строке).
    // Выведите все числа от A до B включительно, в порядке возрастания,
    // если A < B, или в порядке убывания в противном случае.
}

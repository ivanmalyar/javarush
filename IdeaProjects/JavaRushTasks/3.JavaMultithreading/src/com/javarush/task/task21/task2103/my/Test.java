package com.javarush.task.task21.task2103.my;

public class Test {
    public static void main(String[] args) {
        System.out.println(bool(false, true, false, true));

    }
    public static boolean bool(boolean a, boolean b, boolean c, boolean d){

        return (!d && c && a) || (a && b && !d) || (d && !c && b);

    }
}

package com.javarush.task.task19.task1903.my;

public class Test {
    public static void main(String[] args) {

        int i = 501234567;
        String s = String.format("%010d", i);
        System.out.println(s);
        String sub = "(" + s.substring(0, 3) + ")" + s.substring(3, 6) + "-"
                + s.substring(6, 8) + "-"+s.substring(8, 10);

        System.out.println(sub);



    }
}

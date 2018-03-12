package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = byteArrayOutputStream.toString();

        String[] s = result.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        String zn = s[1];
        int res = 0;
        if(zn.equals("+")) res = a + b;
        if(zn.equals("-")) res = a - b;
        if(zn.equals("*")) res = a * b;

        System.out.println(a + " " + zn + " " + b + " = " + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

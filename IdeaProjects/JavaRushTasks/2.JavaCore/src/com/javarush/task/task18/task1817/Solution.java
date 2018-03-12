package com.javarush.task.task18.task1817;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
        //1. Посчитать количество всех символов.
        //2. Посчитать количество пробелов.
        //3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
        //4. Закрыть потоки.
        String fileName = args[0];

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] array = new byte[fileInputStream.available()];
        fileInputStream.read(array);
        fileInputStream.close();
        String text = new String(array);


        double count = text.length();
        double countP = 0;

        for (int i = 0; i < count; i++){
            if (text.charAt(i) == ' ') countP++;
        }

        double k = (100*countP/count);

        //System.out.printf("%.2f",(1.0 * spaces)/symbols * 100);
        System.out.printf("%.2f", k);



















    }
}

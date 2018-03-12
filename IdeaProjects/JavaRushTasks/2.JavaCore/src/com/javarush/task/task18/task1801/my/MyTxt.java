package com.javarush.task.task18.task1801.my;

import java.io.*;

public class MyTxt {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        bufferedWriter.write("19851   Шорты пляжные синие           159.00  12\r\n");
        bufferedWriter.write("19852   Шорты пляжные черные с рисунко173.00  17\r\n");
        bufferedWriter.write("19853   Куртка для сноубордистов, разм10173.991234\r\n");
        bufferedWriter.close();

    }
}

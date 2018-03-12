package com.javarush.task.task19.task1904.my;

import java.io.FileWriter;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("d://a.txt");
        fileWriter.write("Иванов Иван Иванович 31 12 1950\r\n");
        fileWriter.write("Петров Петр Петрович 31 12 1957\r\n");
        fileWriter.write("Sidorov Sidor Sidorovich 10 06 1980\r\n");
        fileWriter.close();
    }
}

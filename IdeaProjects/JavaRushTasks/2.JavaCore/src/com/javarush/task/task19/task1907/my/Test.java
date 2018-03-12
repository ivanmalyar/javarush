package com.javarush.task.task19.task1907.my;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String fileName = "d://a.txt";


        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("black,world.god.settings,mouse:world");
        fileWriter.close();
    }
}

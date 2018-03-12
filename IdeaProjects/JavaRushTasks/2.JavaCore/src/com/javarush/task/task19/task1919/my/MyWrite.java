package com.javarush.task.task19.task1919.my;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyWrite {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d://a.html"));
        bufferedWriter.write("Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\r\n");
        bufferedWriter.write("</span></b></span><span>Super</span><span>girl</span>\r\n");
        bufferedWriter.close();
    }
}

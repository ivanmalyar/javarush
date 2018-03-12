package com.javarush.task.task19.task1917;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;


    public FileConsoleWriter(String fileName) throws IOException {
        //super(fileName);
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        //super(fileName, append);
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        //super(file);
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        //super(file, append);
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        //super(fd);
        fileWriter = new FileWriter(fd);
    }

    public void close() throws IOException {
        fileWriter.close();
    }


    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < off+len; i++){
            System.out.print(cbuf[i]);
        }
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char c:cbuf) {
            System.out.print(c);
        }
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        char[] s = str.toCharArray();
        for (int i = off; i < off + len; i++){
            System.out.print(s[i]);
        }
    }



    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {

        /*FileConsoleWriter writer = new FileConsoleWriter("d://b.txt");
        //writer.write(10);
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        String string = "I love you";
        writer.write(string, 2, 4);*/

    }

}

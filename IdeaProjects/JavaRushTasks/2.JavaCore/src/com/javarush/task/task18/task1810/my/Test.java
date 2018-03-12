package com.javarush.task.task18.task1810.my;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Katya").append("\n");
        stringBuilder.append("Lena").append("\n");
        stringBuilder.append("Masha").append("\n");
        String data = stringBuilder.toString();

        InputStream byteArrayInputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(byteArrayInputStream);

        readAndPrint();

    }

    public static void readAndPrint() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }

        bufferedReader.close();
    }







}

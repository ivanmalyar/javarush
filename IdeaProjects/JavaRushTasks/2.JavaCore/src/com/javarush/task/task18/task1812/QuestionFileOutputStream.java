package com.javarush.task.task18.task1812;
import java.io.*;

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original) {
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

        //В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
        //1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
        //2. Считайте строку.
        //3. Если считанная строка равна "Д", то закрыть поток.
        //4. Если считанная строка не равна "Д", то не закрывать поток.
    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String answerString = bufferedReader.readLine();

        if(answerString.equals("Д")) original.close();

    }
}


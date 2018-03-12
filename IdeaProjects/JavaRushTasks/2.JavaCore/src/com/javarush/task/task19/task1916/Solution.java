package com.javarush.task.task19.task1916;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> strings1 = new ArrayList<>();
    public static List<String> strings2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

        while (reader1.ready()){
            strings1.add(reader1.readLine());
        }
        while (reader2.ready()){
            strings2.add(reader2.readLine());
        }

        reader1.close();
        reader2.close();

        Type sost = Type.SAME;

        int j = 0;
        int circle;
        if(strings1.size() >= strings2.size()) circle = strings1.size();
        else circle = strings2.size();



        for (int i = 0; i < circle; ){

            if(strings1.get(i).equals(strings2.get(j))){
                lines.add(new LineItem(Type.SAME, strings1.get(i)));
                i++;
                j++;
                if(j >= strings2.size()){
                    lines.add(new LineItem(Type.REMOVED, strings1.get(i)));
                    break;
                }
                if(i >= strings1.size()){
                    lines.add(new LineItem(Type.ADDED, strings2.get(j)));
                    break;
                }
            }else if(!strings1.get(i).equals(strings2.get(j+1))){
                lines.add(new LineItem(Type.REMOVED, strings1.get(i)));
                i++;
            }else if(strings1.get(i).equals(strings2.get(j+1))){
                lines.add(new LineItem(Type.ADDED, strings2.get(j)));
                j++;
            }
        }


        for (LineItem l:lines) {
            System.out.println(l.type + " " + l.line);
        }





    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        allLines = Files.readAllLines(Paths.get(fileName1));
        forRemoveLines = Files.readAllLines(Paths.get(fileName2));

        Solution s = new Solution();
        try {
            s.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Строки не совпадают");
        }

    }

    public void joinData () throws CorruptedDataException {

        boolean b = allLines.containsAll(forRemoveLines);

        if (b){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }




    }
}

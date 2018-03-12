package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://a.txt"));
        oos.writeObject(solution);
        oos.close();


    }
}

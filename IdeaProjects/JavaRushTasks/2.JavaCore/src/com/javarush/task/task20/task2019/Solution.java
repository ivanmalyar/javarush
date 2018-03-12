package com.javarush.task.task20.task2019;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution implements Serializable {
    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }
    //В классе Solution не должно быть метода void Solution без параметров.

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("d://a.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("d://a.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }


}

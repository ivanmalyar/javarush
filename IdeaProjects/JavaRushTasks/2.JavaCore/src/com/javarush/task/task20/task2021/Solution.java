package com.javarush.task.task20.task2021;
import java.io.*;

public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream stream) throws IOException {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }




    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SubSolution subSolution = new SubSolution();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://a.txt"));
        oos.writeObject(subSolution);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://a.txt"));
        SubSolution loadedSub = (SubSolution) ois.readObject();
        ois.close();





    }
}

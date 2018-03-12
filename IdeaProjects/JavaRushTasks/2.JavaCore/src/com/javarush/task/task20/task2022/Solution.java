package com.javarush.task.task20.task2022;
import java.io.*;

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    public String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(fileName);
        //В конструкторе класса Solution поле stream должно быть инициализировано
        // новым объектом типа FileOutputStream с параметром(fileName).
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //in.close();
        //В методе readObject(ObjectInputStream in) поле stream должно быть
        // инициализировано новым объектом типа FileOutputStream с параметрами(fileName, true).
        stream = new FileOutputStream(filename, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution("d://b.txt");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://a.txt"));
        oos.writeObject(solution);
        //oos.close();


    }
}

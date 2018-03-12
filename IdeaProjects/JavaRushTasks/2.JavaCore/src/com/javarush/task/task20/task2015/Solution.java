package com.javarush.task.task20.task2015;
import java.io.*;

public class Solution implements Runnable, Serializable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        int count = 0;
        while (true){
            System.out.println(count++);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        new Thread(this).start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution solution = new Solution(1000);

        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(solution);
        fileOutputStream.close();
        oos.close();


        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution s2 = (Solution) ois.readObject();


        fileInputStream.close();
        ois.close();



    }
}

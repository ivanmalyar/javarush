package com.javarush.task.task18.task1823;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String file = bufferedReader.readLine();
            if (file.equals("exit")) break;
            new ReadThread(file).start();

        }
        bufferedReader.close();

        for (Map.Entry<String, Integer> pair:resultMap.entrySet()) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                byte[] bytes = new byte[fileInputStream.available()];

                while (fileInputStream.available() > 0){
                    fileInputStream.read(bytes);
                }
                fileInputStream.close();

                int[] counts = new int[bytes.length];

                for (int i = 0; i < bytes.length; i++){
                    byte b = bytes[i];
                    for (int j = 0; j < bytes.length; j++){
                        if (b == bytes[j]) counts[i] = counts[i] + 1;
                    }
                }

                int maxId = 0;
                int max = counts[0];

                for (int i = 1; i < counts.length; i++){
                    if (counts[i] > max){
                        max = counts[i];
                        maxId = i;
                    }
                }


                synchronized (resultMap) {
                    resultMap.put(fileName, (int) bytes[maxId]);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
//Читайте с консоли имена файлов, пока не будет введено слово "exit".
//Передайте имя файла в нить ReadThread.
//Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
//где параметр String - это имя файла, параметр Integer - это искомый байт.
//Закрыть потоки.
package com.javarush.task.task20.task2003;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static String fileName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();
        bufferedReader.close();
        //fileName = "d://prop.properties";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);      //загрузка
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String, String> pair:properties.entrySet()) {
            prop.setProperty(pair.getKey(), pair.getValue());
        }
        prop.store(outputStream, "my comment");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        Set<String> keys = prop.stringPropertyNames();

        for (String key:keys) {
            properties.put(key, prop.getProperty(key));
        }
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.fillInPropertiesMap();

        System.out.println(properties);


        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        s.save(fileOutputStream);
        fileOutputStream.close();
    }
}

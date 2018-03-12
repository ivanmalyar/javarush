package com.javarush.task.task18.task1825;

import com.javarush.task.task18.task1825.My.FileName;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, byte[]> hm = new HashMap<>();
        String name = null;
        String s;
        try {
            while (!(s=scanner.nextLine()).equals("end")){
                if(name==null) name = s.substring(0, s.lastIndexOf(".part"));
                FileInputStream fis = new FileInputStream(s);
                int number = Integer.parseInt(s.substring(s.lastIndexOf(".part")+5));
                hm.put(number, new byte[fis.available()]);
                fis.read(hm.get(number));
                fis.close();
            }
        } catch (IOException e) {
            /*e.printStackTrace();*/
        }
        scanner.close();

        System.out.println(name);

        try {
            FileOutputStream fos = new FileOutputStream(name);
            int count = 1;
            while (hm.containsKey(count)){
                fos.write(hm.get(count++));
            }
            fos.close();
        } catch (IOException e) {
            /*e.printStackTrace();*/
        }
    }
}


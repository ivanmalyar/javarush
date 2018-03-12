package com.javarush.task.task18.task1827;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        String param;
        String productName;
        String price;
        String quantity;

        try {
            param = args[0];
            quantity = args[args.length - 1];
            price = args[args.length-2];

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1; i < (args.length - 2); i++){
                stringBuilder.append(args[i] + " ");
            }
            productName = stringBuilder.toString().trim();

        } catch (Exception e) {
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        bufferedReader.close();

        //String file = "d://a.txt";

        if (!param.equals("-c")) return;

        List<String> productsList = new ArrayList<>();

        BufferedReader fileBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while (fileBufferedReader.ready()){
            productsList.add(fileBufferedReader.readLine());
        }
        fileBufferedReader.close();

        int maxId = 0;

        for (String s:productsList) {
            String idStr = s.substring(0, 8);
            String[] idStrArr = idStr.split(" ");
            int id = Integer.parseInt(idStrArr[0]);
            if(id > maxId) maxId = id;
        }

        maxId++;
        //id
        String maxIdStr = String.valueOf(maxId);
        char[] maxIdChar = maxIdStr.toCharArray();
        char[] maxIdChar8 = new char[8];

        for (int i = 0; i < maxIdChar.length; i++){
            maxIdChar8[i] = maxIdChar[i];
        }
        for (int i = maxIdChar.length; i < 8; i++){
            maxIdChar8[i] = ' ';
        }
        //productName
        char[] productNameCharArr = productName.toCharArray();
        char[] productNameCharArr30 = new char[30];

        try {
            for (int i = 0; i < productNameCharArr.length; i++){
                productNameCharArr30[i] = productNameCharArr[i];
            }
            for (int i = productNameCharArr.length; i < 30; i++){
                productNameCharArr30[i] = ' ';
            }
        } catch (Exception e) {

        }

        //price
        char[] priceCharArr = price.toCharArray();
        char[] priceCharArr8 = new char[8];

        try {
            for (int i = 0; i < priceCharArr.length; i++){
                priceCharArr8[i] = priceCharArr[i];
            }
            for (int i = priceCharArr.length; i < 8; i++){
                priceCharArr8[i] = ' ';
            }
        } catch (Exception e) {

        }
        //quantity
        char[] quantityCharArr = quantity.toCharArray();
        char[] quantityCharArr4 = new char[4];

        try {
            for (int i = 0; i < quantityCharArr.length; i++){
                quantityCharArr4[i] =quantityCharArr[i];
            }
            for (int i = quantityCharArr.length; i < 4; i++){
                quantityCharArr4[i] = ' ';
            }
        } catch (Exception e) {

        }


        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(maxIdChar8);
        bufferedWriter.write(productNameCharArr30);
        bufferedWriter.write(priceCharArr8);
        bufferedWriter.write(quantityCharArr4);
        bufferedWriter.write("\r\n");
        bufferedWriter.close();


    }
}

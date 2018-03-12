package com.javarush.task.ivan.test.test2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        label1 :for (int i = 1; i <= 5; i++){
            label2: for (int j = 1; j <= 5; j++){
                if (j > 3) break label1;
                System.out.println(i + "_" + j);
            }
        }
    }
}

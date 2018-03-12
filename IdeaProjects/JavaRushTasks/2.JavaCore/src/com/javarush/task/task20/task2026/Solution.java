package com.javarush.task.task20.task2026;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");

    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int l = a[0].length;    //длина поля
        int h = a.length;       //высота поля

        for (int i = 0; i < h; i++){
            for (int j = 0; j < l; j++){
                if(a[i][j] == 1){

                    if(isUgol(i, j, a)) count++;
                }
            }
        }
        return count;
    }

    public static boolean isUgol(int i, int j, byte[][] a){
        int countZero = 0;

        try {
            if(a[i][j+1] == 0) countZero++;
        } catch (ArrayIndexOutOfBoundsException e) {
            countZero++;
        }

        try {
            if(a[i+1][j] == 0) countZero++;
        } catch (ArrayIndexOutOfBoundsException e) {
            countZero++;
        }
        try {
            if(a[i+1][j+1] == 0) countZero++;
        } catch (ArrayIndexOutOfBoundsException e) {
            countZero++;
        }

        if(countZero == 3){
            return true;
        }else{
            return false;
        }
    }



}

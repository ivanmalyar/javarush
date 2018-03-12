package com.javarush.task.task20.task2025;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Long> list = new ArrayList<>();
    public static BigInteger summ;
    public static char[] chars;
    public static String s = "";
    public static String ss = "";
    public static long l = 0;
    public static long ll = 0;
    public static String[] intsStr = new String[10];
    static {
        list.add(1L);list.add(2L);list.add(3L);list.add(4L);list.add(5L);
        list.add(6L);list.add(7L);list.add(8L);list.add(9L);
        intsStr[1] = "1";intsStr[2] = "2";intsStr[3] = "3";intsStr[4] = "4";intsStr[5] = "5";
        intsStr[6] = "6";intsStr[7] = "7";intsStr[8] = "8";intsStr[9] = "9";intsStr[0] = "0";
    }

    public static void main(String[] args) {
        long[] longs = getNumbers(10000);
        for (int i = 0; i < longs.length; i++){
            System.out.println(longs[i]);
        }
    }

    public static long[] getNumbers(long N) {

        myFunc(N);

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void myFunc(long lg){
        char[] ccc = String.valueOf(lg).toCharArray(); //массив из цифр в виде char
        int count = ccc.length;
        for (byte i = 2; i <= count; i++){

            for (byte j = 1; j < 10; j++){
                ss = intsStr[j];
                for (byte n = 1; n <= i; n++){
                    s = s + intsStr[j];
                    ss = ss + intsStr[0];
                }
                l = Long.parseLong(s);
                ll = Long.parseLong(ss.substring(0,i));
                s = "";
                ss = "";

                for (long longL = ll; longL <= l; longL++){
                    isSat(longL);
                }
                System.out.println(ll + " - " + l);
            }
        }
    }




    private static void isSat(long lng){
        chars = String.valueOf(lng).toCharArray(); //массив из цифр в виде char
        int count = chars.length;





        summ = BigInteger.valueOf(0);

        for (byte i = 0; i <  chars.length; i++){
            summ = summ.add(BigInteger.valueOf((int) Math.pow(Character.getNumericValue(chars[i]),  chars.length)));
        }

        if(summ.equals(BigInteger.valueOf(lng))) {
            list.add(lng);
        }
    }


}

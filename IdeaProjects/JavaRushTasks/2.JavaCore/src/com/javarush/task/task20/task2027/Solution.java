package com.javarush.task.task20.task2027;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Word> detectWords = new ArrayList<>();
    public static int[][] crossword;

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},/*X*/
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
           /*Y*/{'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Solution.crossword = crossword;
        for (String word:words) {
            isABC(word);
        }
        //---
        for (Word w:detectWords) {
            System.out.println(w);
        }
        return detectWords;
    }

//метод ищет начальную букву
    public static void isABC(String word){
        int X = crossword[0].length;
        int Y = crossword.length;

        char[] chars = word.toCharArray();

        for (int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                if (crossword[y][x] == chars[0]){
                    isVector(word, x, y);
                }
            }
        }
    }
//метод определяет направление
    public static void isVector(String word, int x, int y){
        char[] chars = word.toCharArray();

        if(chars.length == 1){
            Word word1 = new Word(word);
            word1.setStartPoint(x, y);
            word1.setEndPoint(x, y);
            detectWords.add(word1);
            return;
        }


        try {if(chars[1] == crossword[y][x+1])   method1(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y+1][x+1]) method2(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y+1][x])   method3(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y+1][x-1]) method4(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y][x-1])   method5(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y-1][x-1]) method6(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y-1][x])   method7(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
        try {if(chars[1] == crossword[y-1][x+1]) method8(word, x, y);} catch (ArrayIndexOutOfBoundsException e) {}
    }

//методы для поиска по разным направлениям
    public static void method1(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y][x+i]) {
                   return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x - 1 + word.length(), y);
        detectWords.add(word1);
    }
    public static void method2(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y+i][x+i]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x - 1 + word.length(), y - 1 + word.length());
        detectWords.add(word1);
    }
    public static void method3(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y+i][x]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x, y - 1 + word.length());
        detectWords.add(word1);
    }
    public static void method4(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y+i][x-i]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x + 1 - word.length(), y - 1 + word.length());
        detectWords.add(word1);
    }
    public static void method5(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y][x-i]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x + 1 - word.length(), y);
        detectWords.add(word1);
    }
    public static void method6(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y-i][x-i]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x + 1 - word.length(), y + 1 - word.length());
        detectWords.add(word1);
    }
    public static void method7(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y-i][x]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x, y + 1 - word.length());
        detectWords.add(word1);
    }
    public static void method8(String word, int x, int y){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
                if(chars[i] != crossword[y-i][x+i]) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
        Word word1 = new Word(word);
        word1.setStartPoint(x, y);
        word1.setEndPoint(x - 1 + word.length(), y + 1 - word.length());
        detectWords.add(word1);
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

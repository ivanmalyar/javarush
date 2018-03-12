package com.javarush.task.task23.task2303;

public class Solution {
    int a = 10;
    int x = 5;

    public static class Listener {


        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }

    public void run(){
        Listener listener = new Listener();
    }
}

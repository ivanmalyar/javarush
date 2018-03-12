package com.javarush.task.task23.task2305;

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
        private void method(){
            this.method();

        }
    }

    /*public static Solution[] getTwoSolutions() {
        Solution s1 = new Solution();
        s1.innerClasses[0] = new InnerClass();
        s1.innerClasses[1] = new InnerClass();
        Solution s2 = new Solution();
        s2.innerClasses[0] = new InnerClass();
        s2.innerClasses[1] = new InnerClass();

        Solution[] ss = {s1, s2};
        return ss;
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();

        Solution.InnerClass innerClass =  solution.new InnerClass();


    }

    public void method2(){}
}

package com.javarush.task.task21.task2109;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;


        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            if (this.getClass().equals(B.class)){
                throw new CloneNotSupportedException();
            }
            return (B) super.clone();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return (C) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(45, 50);
        A cloneA = a.clone();

        //B b = new B(55, 66, "class B");
       // B cloneB = b.clone();

        C c = new C(12,123,"class C");
        B cloneC = c.clone();
        System.out.println(cloneC.getName());

    }
}

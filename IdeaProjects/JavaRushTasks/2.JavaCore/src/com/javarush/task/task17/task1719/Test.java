package com.javarush.task.task17.task1719;

public class Test {
    public static void main(String[] args) {

        Context context = new Context();
        MyClass myClass = new MyClass("Класс имплементирующий Bean");
        context.put("One", myClass);

        System.out.println(context.getByName("One"));






    }
}

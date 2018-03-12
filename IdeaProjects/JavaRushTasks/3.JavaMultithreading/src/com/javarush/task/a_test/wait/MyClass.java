package com.javarush.task.a_test.wait;

public class MyClass {

    Object object = new Object();

    public void method() throws InterruptedException {
        synchronized (object){
            object.wait();
        }
    }



}

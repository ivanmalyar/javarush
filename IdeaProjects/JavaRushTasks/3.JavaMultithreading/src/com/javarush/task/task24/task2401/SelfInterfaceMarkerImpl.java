package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    private int b = 0;

    public void printSelf(){
        System.out.println("This is SelfInterfaceMarkerImpl");
    }

    public boolean returnB(){
        return b > 3;
    }

}

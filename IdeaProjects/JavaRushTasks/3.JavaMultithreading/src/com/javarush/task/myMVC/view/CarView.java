package com.javarush.task.myMVC.view;
import java.util.List;

public class CarView implements View {
    @Override
    public void print(List list) {
        for (Object car:list) {
            System.out.println(car);
        }
    }
}

package com.javarush.task.myMVC.view;
import com.javarush.task.myMVC.db.User;
import java.util.List;

public class UserView implements View {
    @Override
    public void print(List list) {
        for (Object user:list) {
            System.out.println(user);
        }
    }
}

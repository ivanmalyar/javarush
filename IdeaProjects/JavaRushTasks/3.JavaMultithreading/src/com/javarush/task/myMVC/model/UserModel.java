package com.javarush.task.myMVC.model;

import com.javarush.task.myMVC.db.DB;
import java.util.List;

public class UserModel implements Model {
    private DB db = new DB();
    @Override
    public List getList() {
        return db.getUsers();
    }
}

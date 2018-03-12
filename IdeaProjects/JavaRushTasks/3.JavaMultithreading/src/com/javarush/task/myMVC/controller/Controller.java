package com.javarush.task.myMVC.controller;
import com.javarush.task.myMVC.db.User;
import com.javarush.task.myMVC.model.CarModel;
import com.javarush.task.myMVC.model.Model;
import com.javarush.task.myMVC.model.UserModel;
import com.javarush.task.myMVC.view.CarView;
import com.javarush.task.myMVC.view.UserView;
import com.javarush.task.myMVC.view.View;

import java.util.List;

public class Controller {
    private Model model;
    private View view;
    private static Controller controller = new Controller();

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        controller.users();
    }

    public void users(){
        model = new UserModel();
        view = new UserView();
        List<User> userList = model.getList();
        view.print(userList);
    }

    public void cars(){
        model = new CarModel();
        view = new CarView();
        List<User> carList = model.getList();
        view.print(carList);
    }


}

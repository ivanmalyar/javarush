package com.javarush.task.myMVC.db;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<User> users = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();

    public DB() {
        users.add(new User("Tom", 25));
        users.add(new User("Bob", 54));
        users.add(new User("Barbara", 17));

        cars.add(new Car("Toyota", 5, 15000));
        cars.add(new Car("BMW", 7, 22000));
        cars.add(new Car("Lada", 1, 3000));
    }

    public List getUsers(){
        return users;
    }

    public List getCars(){
        return cars;
    }


}

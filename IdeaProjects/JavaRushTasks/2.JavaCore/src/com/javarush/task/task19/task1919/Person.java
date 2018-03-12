package com.javarush.task.task19.task1919;

public class Person implements Comparable<Person> {
    private String name;
    private double salary;

    public Person(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {

        return this.name.compareTo(o.getName());


        /*
        if(this.salary > o.getSalary()) return 1;
        else if(this.salary < o.getSalary()) return -1;
        else return 0;*/
    }
}

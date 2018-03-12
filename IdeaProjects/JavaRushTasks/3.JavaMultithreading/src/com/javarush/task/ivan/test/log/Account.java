package com.javarush.task.ivan.test.log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private static int countID;
    private int id;
    private Lock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
        id = ++countID;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void widthraw(double d){
        balance -= d;
    }

    public void deposit(double d){
        balance += d;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", id=" + id +
                '}';
    }
}

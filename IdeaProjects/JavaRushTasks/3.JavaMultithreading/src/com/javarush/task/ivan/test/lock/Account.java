package com.javarush.task.ivan.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private int id;
    private static int countId;
    private Lock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
        id = countId++;
    }

    public Lock getLock() {
        return lock;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double debit){
        balance +=debit;
    }

    public void credit(double credit){
        balance -= credit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", id=" + id +
                '}';
    }
}

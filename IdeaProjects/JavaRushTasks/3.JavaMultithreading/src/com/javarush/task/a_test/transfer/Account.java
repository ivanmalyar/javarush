package com.javarush.task.a_test.transfer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int id;
    private static int count = 0;
    private double balance;
    private Lock lock = new ReentrantLock();

    public double getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public int getId() {
        return id;
    }

    public Account(double balance) {
        this.id = count++;
        this.balance = balance;
    }

    public void debit(double amount){
        try {
            Thread.sleep(100);
            balance += amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void credit(double amount){
        try {
            Thread.sleep(100);
            balance -= amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

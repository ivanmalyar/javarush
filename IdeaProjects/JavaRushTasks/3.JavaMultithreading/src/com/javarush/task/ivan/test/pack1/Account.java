package com.javarush.task.ivan.test.pack1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    Lock lock = new ReentrantLock();

    public Account(int initialbalance) {
        this.balance = initialbalance;
        lock.lock();
    }

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        this.balance -= amount;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

}

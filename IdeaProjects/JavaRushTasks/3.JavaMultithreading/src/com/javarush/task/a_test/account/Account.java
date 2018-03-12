package com.javarush.task.a_test.account;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private int id;
    private static int count;
    private Lock lock = new ReentrantLock();
    private AtomicInteger failCounter = new AtomicInteger(0);

    public Account(double balance) {
        this.id = count++;
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void incFailCounter(){
        failCounter.incrementAndGet();
    }



    public void debit(double amount){
        balance += amount;
    }

    public void credit(double amount){
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Acc id=" + id;
    }
}

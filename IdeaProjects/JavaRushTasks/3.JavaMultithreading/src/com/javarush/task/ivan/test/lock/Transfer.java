package com.javarush.task.ivan.test.lock;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Transfer implements Runnable {
    private static List<Account> accountList;
    Random random = new Random();

    public Transfer(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void transfer(Account a1, Account a2, double sum) throws InterruptedException {
        if (a1.getBalance() > sum){

            if (a1.getLock().tryLock(500, TimeUnit.MILLISECONDS)){
                try {
                    if (a2.getLock().tryLock(500, TimeUnit.MILLISECONDS)){
                        try {
                            a1.credit(sum);
                            //Thread.sleep(10);
                            a2.debit(sum);
                            Thread.sleep(10);
                        }finally {
                            a2.getLock().unlock();
                        }
                    }
                }finally {
                    a1.getLock().unlock();
                }
            }
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int i1 = random.nextInt(4);
                int i2 = random.nextInt(4);
                transfer(accountList.get(i1), accountList.get(i2), 100);

            } catch (Exception e) {
                break;
            }
        }
    }





}

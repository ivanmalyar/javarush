package com.javarush.task.ivan.test.pack1;

import javax.naming.InsufficientResourcesException;

public class Operations {

    public static void main(String[] args) {
        final Account a = new Account(1000);
        final Account b  = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(a, b, 500);
            }
        }).start();

        transfer(b, a, 300);
    }

    public static void transfer(Account acc1, Account acc2, int amount){

        if(acc1.getLock().tryLock()){
            try{
                if (acc2.getLock().tryLock()){
                    try {
                        doTransfer(acc1, acc2, amount);
                    } finally {

                    }
                }
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            } finally {
                acc1.getLock().unlock();
            }
        }




    }

    public static void doTransfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException {
        if(acc1.getBalance() < amount){
            throw new InsufficientResourcesException();
        }
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }

}

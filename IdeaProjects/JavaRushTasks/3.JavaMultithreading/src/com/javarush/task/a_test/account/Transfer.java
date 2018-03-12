package com.javarush.task.a_test.account;
import javax.naming.InsufficientResourcesException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {

    private Account acc1;
    private Account acc2;
    private double amount;

    public Transfer(Account account1, Account account2, double amount) {
        this.acc1 = account1;
        this.acc2 = account2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {

        if (acc1.getLock().tryLock(2, TimeUnit.SECONDS)){
            try {
                if (acc1.getBalance() < amount) {
                    System.out.println("[Недостаточно денег] " + acc1 + " > " + acc2 + " : " + amount);
                }
                if(acc2.getLock().tryLock(2, TimeUnit.SECONDS)){
                    try {
                        doTransfer(acc1, acc2, amount);
                        return true;
                    }finally {
                        acc2.getLock().unlock(); }
                }else {
                    acc1.incFailCounter();
                    return false;
                }
            }finally { acc1.getLock().unlock(); }
        }else {
            acc1.incFailCounter();
            System.out.println("[error lock]");
            return false;
        }
    }


    private static void doTransfer(Account acc1, Account acc2, double amount){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3)*1000);
            acc1.debit(amount);
            acc2.credit(amount);
            System.out.println(acc1 + " > " + acc2 + " : " + amount);
        } catch (InterruptedException e) {
            System.out.println("[interrupt]" + acc1 + " > " + acc2);
        }

    }
}

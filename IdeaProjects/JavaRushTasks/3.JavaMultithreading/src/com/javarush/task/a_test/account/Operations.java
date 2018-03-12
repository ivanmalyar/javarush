package com.javarush.task.a_test.account;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Operations {
    public static void main(String[] args) throws InsufficientResourcesException, InterruptedException, ExecutionException {
        Random random = new Random();
        List<Account> accountList = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            accountList.add(new Account(1000.0));
        }

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i <100; i++){
            service.submit(new Transfer(accountList.get(random.nextInt(accountList.size()-1)),
                    accountList.get(random.nextInt(accountList.size()-1)), random.nextInt(2000)));
        }

        Thread.sleep(10000);
        service.awaitTermination(10000, TimeUnit.MILLISECONDS);
    }

    public static void transfer(Account acc1, Account acc2, double amount) throws InsufficientResourcesException, InterruptedException {

        if (acc1.getLock().tryLock(10, TimeUnit.SECONDS)){
            try {
                if (acc1.getBalance() < amount) throw new InsufficientResourcesException();
                if(acc2.getLock().tryLock(10, TimeUnit.SECONDS)){
                    try {
                        doTransfer(acc1, acc2, amount);
                    }finally {
                        acc2.getLock().unlock(); }
                }else {
                    System.out.println(Thread.currentThread().getName() + " can not lock2");
                }
            }finally { acc1.getLock().unlock(); }
        }else {
            System.out.println(Thread.currentThread().getName() + " can not lock1");
        }

    }

    private static void doTransfer(Account acc1, Account acc2, double amount){
        acc1.debit(amount);
        acc2.credit(amount);
    }

}

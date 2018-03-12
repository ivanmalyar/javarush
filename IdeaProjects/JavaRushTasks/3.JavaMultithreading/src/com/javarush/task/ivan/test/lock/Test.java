package com.javarush.task.ivan.test.lock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static List<Account> accountList = new ArrayList<>();
    private static Transfer transfer = new Transfer(accountList);

    public static void main(String[] args) throws InterruptedException {

        Account account1 = new Account(1000);
        Account account2 = new Account(1000);
        Account account3 = new Account(1000);
        Account account4 = new Account(1000);
        Account account5 = new Account(1000);

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        accountList.add(account4);
        accountList.add(account5);

        ExecutorService service = Executors.newFixedThreadPool(100);
        service.submit(transfer);
        Thread.sleep(10000);
        service.shutdownNow();

        printAcc(accountList);
    }


    public static void printAcc(List<Account> accountList){
        double summBalance = 0;
        for (Account account:accountList) {
            System.out.println(account);
            summBalance += account.getBalance();
        }
        System.out.println("Summ alance: " + summBalance);
    }


}

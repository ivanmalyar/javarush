package com.javarush.task.a_test.transfer;
import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        Transfer transfer = new Transfer();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) accountList.add(new Account(1000));

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {

                    Account account1;
                    Account account2;
                    double amount;
                    try {
                        account1 = accountList.get(rnd.nextInt(99));
                        account2 = accountList.get(rnd.nextInt(99));
                        amount = rnd.nextInt(100);
                        transfer.transfer(account1, account2, amount);

                    } catch (InsufficientResourcesException e) {
                        System.out.println("Ошибка");
                    }
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();

        double allBalance = 0;
        for (Account a:accountList) {
            allBalance = allBalance + a.getBalance();
        }
        System.out.println(allBalance);






    }
}

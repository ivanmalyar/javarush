package com.javarush.task.ivan.test.log;
import java.util.concurrent.TimeUnit;

public class Operations {

    public static void main(String[] args) throws Exception {
        Account a1 = new Account(1000);
        Account a2 = new Account(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a1, a2, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        transfer(a2, a1, 500);


        Thread.sleep(10000);
        System.out.println(a1);
        System.out.println(a2);

    }

    public static void transfer(Account a1, Account a2, double d) throws Exception {
        if (a1.getBalance() < d) throw new Exception();

        System.out.println("["+Thread.currentThread().getName()+"] trying lock id" + a1.getId());
        if (a1.getLock().tryLock(10000, TimeUnit.MILLISECONDS)){
            System.out.println("["+Thread.currentThread().getName()+"] lock id" + a1.getId());
            Thread.sleep(1000);
            try{
                System.out.println("["+Thread.currentThread().getName()+"] trying lock id" + a2.getId());
                if (a2.getLock().tryLock(10000, TimeUnit.MILLISECONDS)){
                    System.out.println("["+Thread.currentThread().getName()+"] lock id"+ a2.getId());
                    Thread.sleep(1000);
                    try{
                        a1.widthraw(d);
                        a2.deposit(d);
                    }finally {
                        a2.getLock().unlock();
                        System.out.println("["+Thread.currentThread().getName()+"] unlock id" + a2.getId());
                    }
                }
            }finally {
                a1.getLock().unlock();
                System.out.println("["+Thread.currentThread().getName()+"] unlock id"+ a1.getId());
            }
        }





        /*
        System.out.println("["+Thread.currentThread().getName()+"] trying lock1...");

        Account acc1 = a1;
        Account acc2 = a2;
        if (a2.getId() < a1.getId()){
            acc1 = a2;
            acc2 = a1;
        }

        synchronized (acc1){
            System.out.println("["+Thread.currentThread().getName()+"] lock 1");
            System.out.println("["+Thread.currentThread().getName()+"] trying lock2...");
            Thread.sleep(1000);
            synchronized (acc2){
                System.out.println("["+Thread.currentThread().getName()+"] lock 2");
                a1.widthraw(d);
                a2.deposit(d);
            }
        }*/
    }
}

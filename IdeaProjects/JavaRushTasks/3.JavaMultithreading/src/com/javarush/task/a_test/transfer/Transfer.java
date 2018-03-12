package com.javarush.task.a_test.transfer;
import javax.naming.InsufficientResourcesException;
import java.util.concurrent.TimeUnit;

public class Transfer {


    public void transfer(Account acc1, Account acc2, double amount) throws InsufficientResourcesException {
        if (acc1.getBalance() < amount) throw new InsufficientResourcesException();
        try {
            if (acc1.getLock().tryLock(100, TimeUnit.MILLISECONDS)){
                try {
                    if (acc2.getLock().tryLock()){
                        acc1.credit(amount);
                        acc2.debit(amount);
                        acc1.getLock().unlock();
                        acc2.getLock().unlock();
                        System.out.println("Перевод с аккаунта " + acc1.getId() + " На аккаунт " +
                        acc2.getId() + " : " + amount);
                    }else throw new InsufficientResourcesException();
                }catch (Exception e){}
            }else throw new InsufficientResourcesException();
        }catch (Exception e){}
    }

}

package com.javarush.task.task25.task2513;
import java.util.Random;
//Обеспечение отсутствия прерывания важной операции

public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        if (RANDOM.nextInt(5000) > THRESHOLD_VALUE) Thread.yield();
        to.setBalance(to.getBalance() + amount);

    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "balance=" + balance +
                    '}';
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Account a1 = s.new Account();
        a1.setBalance(10000);
        Account a2 = s.new Account();
        a2.setBalance(20000);

        s.moveMoney(a1, a2, 1000);
        System.out.println(a1);
        System.out.println(a2);

    }
}

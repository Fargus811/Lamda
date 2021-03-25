package main.java.com.sergeev.task2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 1. get list with all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
 * 2. get all non-locked accounts with too much money (balance >= 100 000 000) and save it to the variable accountsWithTooMuchMoney
 */
public class Task2_1 {

    public static void main(String[] args) {
        Account accountFirst = new Account("1", 100l, false);
        Account accountSecond = new Account("2", 9999999999l, false);
        Account accountThird = new Account("3", -1l, true);
        List<Account> accounts = List.of(accountFirst, accountSecond, accountThird);
        List<Account> nonEmptyAccounts = accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .collect(Collectors.toList());
        List<Account> accountsWithToMuchMoney = accounts.stream()
                .filter(account -> !account.isLocked() && account.getBalance() >= 100000000)
                .collect(Collectors.toList());
        System.out.println("Non empty accounts size: " + nonEmptyAccounts.size());
        System.out.println("Accounts with too much money size: " + accountsWithToMuchMoney.size());
    }

    static class Account {

        private String number;
        private Long balance;
        private boolean isLocked;

        public Account(String number, Long balance, boolean isLocked) {
            this.number = number;
            this.balance = balance;
            this.isLocked = isLocked;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Long getBalance() {
            return balance;
        }

        public void setBalance(Long balance) {
            this.balance = balance;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void setLocked(boolean locked) {
            isLocked = locked;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return isLocked == account.isLocked && Objects.equals(number, account.number) && Objects.equals(balance, account.balance);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, balance, isLocked);
        }
    }
}

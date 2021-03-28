package main.java.com.sergeev.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingLong;

/**
 * Task to write a collector that calculates the total sum of transactions (long type, not integer)
 * by each account (i.e. by account number).
 */
public class Task4_3 {

    static Map<String, Long> totalSum(List<Transaction> transactions) {
        Map<String, Long> result = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getAccount().getNumber(),
                        summingLong(Transaction::getSum)));
        return result;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        Account accountFirst = new Account("101", 2000L);
        Account accountSecond = new Account("102", 2500L);
        Account accountThird = new Account("103", 3000L);
        transactions.add(new Transaction("101_1", 5000L, accountFirst));
        transactions.add(new Transaction("101_2", 5000L, accountFirst));
        transactions.add(new Transaction("102_1", 10000L, accountSecond));
        transactions.add(new Transaction("102_2", 10000L, accountSecond));
        transactions.add(new Transaction("103_1", 15000L, accountThird));
        transactions.add(new Transaction("103_2", 15000L, accountThird));
        //expected
        //101=10000
        //102=20000
        //103=30000
        for (Map.Entry<String, Long> msl : totalSum(transactions).entrySet()) {
            System.out.println(msl.toString());
        }
    }

    static class Account {
        private String number;
        private Long balance;

        public Account(String number, Long balance) {
            this.number = number;
            this.balance = balance;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return Objects.equals(number, account.number) && Objects.equals(balance, account.balance);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, balance);
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }

    static class Transaction {
        private String uuid;
        private Long sum;
        private Account account;

        public Transaction(String uuid, Long sum, Account account) {
            this.uuid = uuid;
            this.sum = sum;
            this.account = account;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public Long getSum() {
            return sum;
        }

        public void setSum(Long sum) {
            this.sum = sum;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return Objects.equals(uuid, that.uuid) && Objects.equals(sum, that.sum) && Objects.equals(account, that.account);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uuid, sum, account);
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "uuid='" + uuid + '\'' +
                    ", sum=" + sum +
                    ", account=" + account +
                    '}';
        }
    }
}

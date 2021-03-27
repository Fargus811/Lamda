package main.java.com.sergeev.task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Task calculates the general sum of canceled transactions for all non empty accounts in the list.
 */
public class Task3_7 {

    public static void main(String[] args) {
        Transaction transactionFirst = new Transaction(State.CANCELED, 1000L);
        Account accountFirst = new Account(0L, Collections.singletonList(transactionFirst));

        Transaction transactionSecond = new Transaction(State.FINISHED, 8000L);
        Transaction transactionThird = new Transaction(State.CANCELED, 10_000L);
        Account accountSecond = new Account(8000L, Arrays.asList(transactionSecond, transactionThird));

        Transaction transactionFourth = new Transaction(State.FINISHED, 9000L);
        Transaction transactionFifth = new Transaction(State.CANCELED, 3000L);
        Account accountThird = new Account(8000L, Arrays.asList(transactionFourth, transactionFifth));

        // 13000 expected
        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(Arrays.asList(accountFirst, accountSecond, accountThird)));
    }

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();
    }

    static class Transaction {
        State state;
        Long sum;

        public Transaction(State state, Long sum) {
            this.state = state;
            this.sum = sum;
        }

        public State getState() {
            return state;
        }

        public Long getSum() {
            return sum;
        }
    }

    static class Account {
        Long balance;
        List<Transaction> transactions;

        public Account(Long balance, List<Transaction> transactions) {
            this.balance = balance;
            this.transactions = transactions;
        }

        public Long getBalance() {
            return balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }

    enum State {
        CANCELED,
        FINISHED
    }
}

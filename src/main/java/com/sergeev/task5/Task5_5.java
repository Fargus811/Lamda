package main.java.com.sergeev.task5;

import java.util.*;

/**
 * 1.Task to write a method findUserByLogin(String login) that returns an optional value of type Optional<User>.
 * If the user exists in the users set you need to return non-empty optional wrapping the user inside,
 * otherwise returned optional should be empty.
 *
 * 2. Task to write printBalanceIfNotEmpty(String userLogin)that prints an account balance for an existing user
 * if `balance > 0
 */
public class Task5_5 {

    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin)
                .map(User::getAccount)
                .map(Account::getBalance)
                .filter(balance -> balance > 0)
                .map(v -> new String(userLogin + ": " + v))
                .ifPresent(System.out::println);
    }

    class Account{

        private UUID guid;
        private Long balance;

        public Account(UUID guid, Long balance) {
            this.guid = guid;
            this.balance = balance;
        }

        public UUID getGuid() {
            return guid;
        }

        public void setGuid(UUID guid) {
            this.guid = guid;
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
            return Objects.equals(guid, account.guid) && Objects.equals(balance, account.balance);
        }

        @Override
        public int hashCode() {
            return Objects.hash(guid, balance);
        }
    }

    class User{

        private String login;
        private Account account;

        public User(String login, Account account) {
            this.login = login;
            this.account = account;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
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
            User user = (User) o;
            return Objects.equals(login, user.login) && Objects.equals(account, user.account);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login, account);
        }
    }
}

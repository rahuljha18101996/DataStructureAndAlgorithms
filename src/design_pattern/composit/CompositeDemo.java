package design_pattern.composit;

/*
* Composite Design Pattern
*
* Structural Design Patter : Improve the structure of code
* Composite lets the client treat individual Object(Leaf) and Composition of Objects (Composite)Uniformly
* Four Participant: Component, Leaf, Composite, Client
* If Object is leaf node, request is handled directly, If object is composite node, it forward request to child, so some operation and combine operations.
*
* */

import java.util.*;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingAccount extends Account {
    private String AccountId;
    public SavingAccount(String AccoutnId,double balance) {
        super(balance);
        this.AccountId = AccoutnId;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }
}

class DepositAccount extends Account {
    private String AccountId;
    public DepositAccount(String AccoutnId,double balance) {
        super(balance);
        this.AccountId = AccoutnId;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }
}

class CompositAccount {
    private Set<Account> accounts;

    public CompositAccount() {
        this.accounts = new HashSet<>();
    }

    public void addAccount(Account...account) {
        accounts.addAll(Arrays.asList(account));
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public double totalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}
public class CompositeDemo {
    public static void main(String[] args) {
        Account a1 = new SavingAccount("S100",100);
        Account a2 = new DepositAccount("D102",10);
        Account a3 = new DepositAccount("D111",40);

        CompositAccount account = new CompositAccount();
        account.addAccount(a1,a2,a3);

        System.out.println(account.totalBalance());
    }
}

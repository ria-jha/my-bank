package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    public abstract double interestEarned();

    public double getBalance() {
        double amount = 0.0;
        for (Transaction t : transactions)
            amount += t.getAmount();

        return amount;
    }

    public String statementForAccount(){
        return getAccountType() + transactionHistory();
    }

    public abstract String getAccountType();

    private String transactionHistory(){
        String s = "";
        for (Transaction t : transactions){
            s += "  " + t.getTransactionDetails() + "\n";

        }

        double total = getBalance();
        s += "Total " + Transaction.toDollars(total);
        return s;
    }


}

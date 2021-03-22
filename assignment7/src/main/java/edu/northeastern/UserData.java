package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private User user;
    private String password;
    private double accountBalance;
    private List<Transaction> transactions;

    public UserData(User user, String password, double accountBalance) {
        this.user = user;
        this.password = password;
        this.accountBalance = accountBalance;
        this.transactions = new ArrayList<>();
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public User getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double deposit(double depositAmount) {
        if(this.accountBalance + depositAmount - Atm.TRANSACTION_FEE < 0) return -1;
        this.accountBalance += depositAmount;
        this.accountBalance -= Atm.TRANSACTION_FEE;
        addTransaction("Deposit", depositAmount);
        return this.accountBalance;
    }

    public double withdraw(double withdrawAmount) {
        if(this.accountBalance - withdrawAmount - Atm.TRANSACTION_FEE < 0) return -1;
        this.accountBalance -= withdrawAmount;
        addTransaction("WithDraw", withdrawAmount);
        return this.accountBalance;
    }

    private void addTransaction(String transactionType, double transactionAmount){
        Transaction transaction = new Transaction(transactionType, transactionAmount);
        transactions.add(transaction);
    }

    public String getLastTenTransactions(){
        int textPadding = 10;
        int inputPadding = 2;
        String textFormat = "%-" + textPadding + "s%-" + inputPadding + "s%-2s";

        StringBuilder lastTransactions = new StringBuilder();
        for (Transaction transaction : transactions.subList(Math.max(0, transactions.size() - 10), transactions.size())) {
            lastTransactions.append(String.format(textFormat, transaction.getTransactionType(), ":", transaction.getTransactionAmount()));
            lastTransactions.append("\n");
        }
        return lastTransactions.toString();
    }

}

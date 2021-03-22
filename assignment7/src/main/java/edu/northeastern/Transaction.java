package edu.northeastern;

public class Transaction {
    private String transactionType;
    private double transactionAmount;

    public Transaction(String transactionType, double transactionAmount) {
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}

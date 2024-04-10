package DAO;

import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int surplusItemId;
    private int userId;
    private Timestamp transactionDate;
    private int quantityClaimed;

    // Constructors
    public Transaction() {
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getSurplusItemId() {
        return surplusItemId;
    }

    public void setSurplusItemId(int surplusItemId) {
        this.surplusItemId = surplusItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantityClaimed() {
        return quantityClaimed;
    }

    public void setQuantityClaimed(int quantityClaimed) {
        this.quantityClaimed = quantityClaimed;
    }
}


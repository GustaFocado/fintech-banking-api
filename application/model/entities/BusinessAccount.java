package entities;

public class BusinessAccount extends Account {

    private double transactionFee;
    private double creditLimit;

    public BusinessAccount(double balance, String holderName, int number, double transactionFee, double creditLimit) {
        super(balance, holderName, number);
        this.transactionFee = transactionFee;
        this.creditLimit = creditLimit;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void applyTransactionFee() {
        if (transactionFee < 0) {
            throw new IllegalStateException("The transaction fee cannot be negative.");
        }

        if (transactionFee > 0) {
            withdraw(transactionFee);
        }
    }

    @Override
    public void loan(double amount) {
        if (amount > creditLimit) {
            throw new IllegalArgumentException("The loan amount exceeds the credit limit.");
        }

        super.loan(amount);
    }
}

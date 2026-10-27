package entities;

public class Account {

    private double balance;
    private String holderName;
    private final int number;

    public Account(double balance, String holderName, int number) {
        this.balance = balance;
        this.holderName = holderName;
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getNumber() {
        return number;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }

    public void transfer(Account destination, double amount) {
        if (destination == null) {
            throw new IllegalArgumentException("The destination account cannot be null.");
        }

        if (destination == this) {
            throw new IllegalArgumentException("The destination account must be different from the source account.");
        }

        withdraw(amount);
        destination.balance += amount;
    }

    public void loan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The loan amount must be positive.");
        }

        balance += amount;
    }
}

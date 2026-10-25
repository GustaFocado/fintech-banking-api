package entities;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(double balance, String holderName, int number, double interestRate) {
        super(balance, holderName, number);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        if (interestRate < 0) {
            throw new IllegalStateException("The interest rate cannot be negative.");
        }

        if (interestRate > 0) {
            loan(getBalance() * interestRate);
        }
    }
}
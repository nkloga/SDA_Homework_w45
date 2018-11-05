package ee.nkloga;

import java.text.DecimalFormat;
import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        dateCreated = new Date();
        this.id = id;
        this.balance = balance;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return (balance / 100) * getAnnualInterestRate();
    }

    public void withdraw(double withdrawAmount) {
        if (balance < withdrawAmount) {
            System.out.println("Insufficient founds: Cannot withdraw amount of "
                    + withdrawAmount + "$ from the account with id: " + id);
        } else {
            System.out.println("- Withdraw of " + withdrawAmount + "$ from the account with id: " + id);
            balance = balance - withdrawAmount;
            getBalance();
        }
    }

    public void deposit(double depositAmount) {
        System.out.println("+ Deposit of " + depositAmount + "$ to the account with id: " + id);
        balance = balance + depositAmount;
        getBalance();
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getBalance() {
        System.out.println("Current account balance is " +
                this.balance + "\n------------------------------------------------------------------------");
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public String toString() {
        return " ee.nkloga.Account with id " + id + " has been created at: " + dateCreated
                + "\nIt has a balance of: " + balance + "$"
                + "\nThe montlhy intrest rate is: " + df2.format(getMonthlyInterestRate()) + "%"
                + "\nMonthly interest is: " + getMonthlyInterest()
                + "$\n------------------------------------------------------------------------";
    }
}
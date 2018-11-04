import java.text.DecimalFormat;
import java.util.Date;

/*
*Task2:* Design a class named Account that contains:
■ A private int data field named id for the account (default 0).
■ A private double data field named balance for the account (default 0).
■ A private double data field named annualInterestRate that stores the cur-
rent interest rate (default 0). Assume all accounts have the same interest rate.
■ A private Date data field named dateCreated that stores the date when the
account was created.
■ A no-arg constructor that creates a default account.
■ A constructor that creates an account with the specified id and initial balance.
■ The access or and mutator methods for id,balance,and annualInterestRate.
■ The accessor method for dateCreated.
■ A method named getMonthlyInterestRate() that returns the monthly
interest rate.
■ A method named getMonthlyInterest() that returns the monthly interest.
■ A method named withdraw that withdraws a specified amount from the
account.
■ A method named deposit that deposits a specified amount to the account.
*/


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

    //    public Date getDateCreated() {
//        return dateCreated;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//    public int getId() {
//        return id;
//    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return (balance / 100) * getAnnualInterestRate();
    }

    public void withdraw(double withdrawAmount) {
        if (balance < withdrawAmount) {
            System.out.println("Insufficient founds: Cannot withdraw amount of " + withdrawAmount + "$ from the account with id: " + id);
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
        System.out.println("Current account balance is " + this.balance + "\n------------------------------------------------------------------------");
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public String toString() {
        return " Account with id " + id + " has been created at: " + dateCreated
                + "\nIt has a balance of: " + balance + "$"
                + "\nThe montlhy intrest rate is: " + df2.format(getMonthlyInterestRate()) + "%"
                + "\nMonthly interest is: " + getMonthlyInterest()
                + "$\n------------------------------------------------------------------------";
    }
}
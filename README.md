# SDA_Homework_w45

Task2: Design a class named ee.nkloga.Account that contains:
- A private int data field named id for the account (default 0).
- A private double data field named balance for the account (default 0).
- A private double data field named annualInterestRate that stores the current interest rate (default 0). 
Assume all accounts have the same interest rate.
- A private Date data field named dateCreated that stores the date when the account was created.
- A no-arg constructor that creates a default account.
- A constructor that creates an account with the specified id and initial balance.
- The access or and mutator methods for id,balance,and annualInterestRate.
- The accessor method for dateCreated.
- A method named getMonthlyInterestRate() that returns the monthly interest rate.
- A method named getMonthlyInterest() that returns the monthly interest.
- A method named withdraw that withdraws a specified amount from the account.
- A method named deposit that deposits a specified amount to the account.

Task3: Write a test program that creates an ee.nkloga.
- Account object with an account ID of 1122, a balance of $20,000, 
and an annual interest rate of 4.5%. 
- Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000, and print the balance,
the monthly interest, and the date when this account was created

Task4: Use the ee.nkloga.Account class created in *Task2* to simulate an ee.nkloga.ATM machine.
Create ten accounts in an array with id 0, 1, . . . , 9, and initial balance $100.
The system prompts the user to enter an id. If the id is entered incorrectly,
ask the user to enter a correct id.
Once an id is accepted, the main menu is displayed as shown in the sample run.
You can enter a choice 1 for viewing the current balance, 2 for withdrawing money,
3 for depositing money, and 4 for exiting the main menu. Once you exit,
the system will prompt for an id again.
Thus, once the system starts, it will not stop.

package org.example;
//"1. Design a class for a simple bank account. The class should have the following features:
//        - Instance variables for the account holder's name, account number, and balance.
//        - A constructor that allows the user to create an account with a given name, account number, and balance.
//        - A method that allows the user to make a deposit to the account.
//        - A method that allows the user to make a withdrawal from the account.
//        - A method that returns the current balance of the account."


import java.util.logging.*;


class Bank {
    String accountHolderName;
    int accountHolderNumber;
    double accountHolderBalance;

    Logger l=Logger.getLogger("Bank");
    Bank(String name, int number, double amount) {
        // constructor for allow user to create
        this.accountHolderName = name;
        this.accountHolderNumber = number;
        this.accountHolderBalance = amount;
    }

    public void display() {

        l.log(Level.INFO, () ->"Name : " + this.accountHolderName);

        l.log(Level.INFO, () -> "Account Number :" + this.accountHolderNumber);
        l.log(Level.INFO, () -> "Your Current Balance :" + this.accountHolderBalance);

    }

    public void deposit(double depositAmount) {
        this.accountHolderBalance += depositAmount;
        display();
    }

    public void withDraw(double withDrawAmount) {
        try{
            if (this.accountHolderBalance - withDrawAmount <= 1000)
                throw new MyException("WithDraw Failed !");
            this.accountHolderBalance -= withDrawAmount;
            l.info("WithDraw Successful !");
            display();
        }
        catch (MyException e)
        {
            l.info(this.accountHolderName);
            String s=" \nWithDraw Failed !\nYour minimum Balance is Low";
            l.info(s);
        }
    }


}
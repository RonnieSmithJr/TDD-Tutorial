package com.thoughtworks.tddintro.account;

/**
 * Created by Ronnie on 9/19/16.
 */
public class Account {
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public void deposit(int depositAmount){
        this.balance += depositAmount;
    }

    public void withdraw(int withdrawAmount){
        if(withdrawAmount <= this.balance) {
            this.balance = this.balance - withdrawAmount;
        }
    }

    public int getBalance(){return this.balance;}

}

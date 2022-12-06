package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import interfaces.Operations;

public abstract class Account implements Operations,Cloneable {
    protected String accountNumber;
    protected double amount = 0;

    protected Account() {
    }

    @Override
    public Account clone() {
        try {
            return (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public enum TYPE {
        EUR, RON
    };

    protected Account(String accountNumber, double amount) throws DeposeException, IllegalAccountException {
        this.accountNumber = accountNumber;
        if(amount < 0)
            throw new IllegalAccountException("Cannot create an account with a negative balance : " + amount);
        depose(amount);
    }

    @Override
    public double getTotalAmount() {
        return amount + amount * getInterest();
    }

    @Override
    public void depose(double amount) throws DeposeException {
        if(amount < 0)
            throw new DeposeException("Cannot depose a negative amount : " + amount);
        this.amount += amount;
    }

    @Override
    public void retrieve(double amount) throws RetrieveException {
        if(amount > this.amount)
            throw new RetrieveException("Cannot retrieve more than the current balance : " + amount);
        else if(amount < 0)
            throw new RetrieveException("Cannot retrieve a negative amount : " + amount);
        this.amount -= amount;
    }

    public double getBalance(){
        return this.amount;
    }

    public String toString() {
        return "Account: code=" + accountNumber + ", amount=" + amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

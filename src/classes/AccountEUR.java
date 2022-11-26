package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import interfaces.Transfer;

public class AccountEUR extends Account implements Transfer {
    public AccountEUR(String accountNumber, double amount) throws DeposeException, IllegalAccountException {
        super(accountNumber, amount);
    }

    public double getInterest() {
        return 0.01;
    }

    @Override
    public String toString() {
        return "Account EUR [" + super.toString() + "]";
    }

    @Override
    public void transferTo(Account c, double s) throws RetrieveException {
        super.retrieve(s);
        try{
            c.depose(s);
        } catch(DeposeException e){
            e.printStackTrace();
        }
    }
}

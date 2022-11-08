package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import interfaces.Transfer;

public class AccountRON extends Account implements Transfer {
    public AccountRON(String accountNumber, double amount) throws DeposeException, IllegalAccountException {
        super(accountNumber, amount);
    }

    public double getInterest() {
        if (amount < 500)
            return 0.03;
        else
            return 0.08;

    }

    @Override
    public String toString() {
        return "Account RON [" + super.toString() + "]";
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

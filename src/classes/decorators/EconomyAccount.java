package classes.decorators;

import classes.Account;
import classes.AccountRON;

public class EconomyAccount extends AccountDecorator {

    public EconomyAccount(Account account){
        super(account);
    }

    @Override
    public double getInterest() {
        return super.account instanceof AccountRON ? super.account.getBalance() < 500 ? 0.16 : 0.24 : 0.12;
    }
}

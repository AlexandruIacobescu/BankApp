package classes.decorators;

import classes.Account;

public abstract class AccountDecorator extends Account {
    Account account;

    protected AccountDecorator(Account account) {
        this.account = account;
    }
}

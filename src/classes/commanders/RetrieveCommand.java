package classes.commanders;

import classes.Account;
import exceptions.RetrieveException;
import interfaces.Command;

public class RetrieveCommand implements Command {
    private Account account;
    private double amount;

    public RetrieveCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() throws RetrieveException {
        account.retrieve(amount);
    }
}

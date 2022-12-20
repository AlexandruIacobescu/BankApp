package classes.commanders;

import classes.Account;
import classes.Client;
import exceptions.AccountClosingException;
import interfaces.Command;

public class CloseAccountCommand implements Command {
    private Client client;
    private String accountNumber;

    public CloseAccountCommand(Client client, String accountNumber) {
        this.client = client;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() throws AccountClosingException {
        client.closeAccount(accountNumber);
    }
}

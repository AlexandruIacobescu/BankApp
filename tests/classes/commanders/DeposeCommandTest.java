package classes.commanders;

import classes.Account;
import classes.Client;
import exceptions.AccountClosingException;
import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import interfaces.Command;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class DeposeCommandTest {

    @Test
    public void deposeAnAmountIntoAClientAccountUsingTheCommanderClass() throws DeposeException, IllegalAccountException, AccountClosingException, RetrieveException {
        Client client1 = new Client.ClientBuilder()
                .name("Anna Gunn")
                .address("44th Downing Street")
                .dateOfBirth("2001-09-06")
                .addAccount(Account.TYPE.RON, "9874-2558-6321-2011", 620)
                .build();

        client1.addAccount(Account.TYPE.RON, "9874-3652-7412-5896", 250);

        Command command = new DeposeCommand(client1.getAccount("9874-3652-7412-5896"), 200);
        command.execute();

        Assertions.assertEquals(463.5, client1.getAccount("9874-3652-7412-5896").getTotalAmount());
    }
}
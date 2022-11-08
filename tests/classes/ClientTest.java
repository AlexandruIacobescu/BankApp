package classes;

import exceptions.DeposeException;
import exceptions.ExistingAccountException;
import exceptions.IllegalAccountException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void createValidClientWithRONAccountTest() throws DeposeException, IllegalAccountException {
        Client client = new Client("Anna Holt", "42nd Downing Street", Account.TYPE.RON, "1234-5678-9101-1213", 250);
    }

    @Test
    public void createValidClientWithInvalidRONAccountTest() {
        double amount = -250;
        IllegalAccountException exception = Assertions.assertThrows(IllegalAccountException.class, () -> {
            Client client = new Client("Anna Holt", "42nd Downing Street", Account.TYPE.RON, "1234-5678-9101-1213", amount);
        });
        Assertions.assertEquals("Cannot create an account with a negative balance : " + amount, exception.getMessage());
    }

    @Test
    public void addAccountToClientTest() throws DeposeException, IllegalAccountException {
        Client client = new Client("Anna Holt", "42nd Downing Street", Account.TYPE.RON, "1234-5678-9101-1213", 250);
        client.addAccount(Account.TYPE.RON, "1234-5678-9101-1213", 900);
    }

}
package classes;

import exceptions.DeposeException;
import exceptions.ExistingAccountException;
import exceptions.IllegalAccountException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BankTest {

    @Test
    public void createMoreClientsWithTheSameAccountTest() throws DeposeException, IllegalAccountException {
        Bank bank = new Bank("UniCredit Bank");

        Client client1 = new Client("Anna Holt", "42nd Downing Street", Account.TYPE.RON, "1234-5678-9101-1213", 250);
        Client client2 = new Client("Madison Leigh", "42nd Downing Street", Account.TYPE.RON, "1234-5678-9101-1213", 250);
        ExistingAccountException exception = Assertions.assertThrows(ExistingAccountException.class, () -> {
            bank.addClient(client1);
            bank.addClient(client2);
        });
        Assertions.assertEquals("This account number is already owned by another client : " + "1234-5678-9101-1213", exception.getMessage());
    }
}
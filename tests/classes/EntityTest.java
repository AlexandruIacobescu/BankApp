package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    @Test
    public void bankClientCommunicationTest() throws DeposeException, IllegalAccountException {
        ApplicationMediator mediator = new ApplicationMediator();
        Bank bank = Bank.getInstance("NewBank", mediator);

        Client client1 = new Client.ClientBuilder()
                .name("Anna Gunn")
                .address("44th Downing Street")
                .dateOfBirth("2001-09-06")
                .addAccount(Account.TYPE.RON, "9874-2558-6321-2011", 620)
                .mediator(mediator)
                .build();

        mediator.addClient(bank);
        mediator.addClient(client1);

        bank.send("Hello message");
        client1.send("Hello Response");
    }

}
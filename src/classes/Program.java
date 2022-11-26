package classes;

import exceptions.DeposeException;
import exceptions.ExistingAccountException;
import exceptions.IllegalAccountException;

public class Program {
    public static void main(String[] args) throws DeposeException, IllegalAccountException, ExistingAccountException {
        Bank bank = new Bank("NewBank");

        Client client1 = new Client.ClientBuilder()
                .name("Anna Gunn")
                .address("44th Downing Street")
                //.dateOfBirth("2001-09-06")
                .build();
        System.out.println(client1);
    }
}

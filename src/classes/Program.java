package classes;

import exceptions.DeposeException;
import exceptions.ExistingAccountException;
import exceptions.IllegalAccountException;

import java.util.List;

public class Program {
    public static void main(String[] args) throws DeposeException, IllegalAccountException, ExistingAccountException {
        Bank bank = new Bank("NewBank");

        Client client1 = new Client("Madison Leigh", "796 Martha Ellen Drive", Account.TYPE.RON, "7584-6235-7391-8852", 500);
        Client client2 = new Client("Simon Farrell", "2480 Buck Drive", Account.TYPE.RON, "9158-4562-7841-5563", 698);
        Client client3 = new Client("Alexander Siddig", "4908 Highland Drive", Account.TYPE.RON, "853-8741-8998-2301", 1064);
        Client client4 = new Client("Jason Alexander", "275 Hillview Street", Account.TYPE.RON, "9668-1254-8965-2374", 4110);

        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);


    }
}

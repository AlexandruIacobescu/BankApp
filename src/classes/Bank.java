package classes;

import exceptions.ExistingAccountException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients;
    private String bankCode = null;

    public Bank(String bankCode) {
        this.bankCode = bankCode;
        clients = new ArrayList<>();
    }

    public void addClient(Client c) throws ExistingAccountException {
        for(Client client : clients){
            for(Account account : client.getAccounts()){
                for(Account account1 : c.getAccounts()){
                    if(account.getAccountNumber().equals(account1.getAccountNumber()))
                        throw new ExistingAccountException("This account number is already owned by another client : " + account.getAccountNumber());
                }
            }
        }
        clients.add(c);
    }

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Bank [code=" + bankCode + ", clients=" + clients + "]";
    }
}

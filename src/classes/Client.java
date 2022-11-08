package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String address;
    private List<Account> accounts;

    public Client(String name, String address, Account.TYPE type, String accountNumber, double amount) throws DeposeException, IllegalAccountException {
        this.name = name;
        this.address = address;
        accounts = new ArrayList<>();
        addAccount(type, accountNumber, amount);
    }

    public void addAccount(Account.TYPE type, String accountNumber, double amount) throws DeposeException, IllegalAccountException {
        Account c = null;
        if (type == Account.TYPE.EUR)
            c = new AccountEUR(accountNumber, amount);
        else if (type == Account.TYPE.RON)
            c = new AccountRON(accountNumber, amount);
        accounts.add(c);
    }

    public Account getAccount(String accountCode) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountCode)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccounts(){
        List<Account> clonedAccounts = new ArrayList<>();
        for(Account account : accounts){
            clonedAccounts.add(account.clone());
        }
        return clonedAccounts;
    }

    @Override
    public String toString() {
        return "\n\tClient [name=" + name + ", address=" + address + ", accounts=" + accounts + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

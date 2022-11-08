package interfaces;

import classes.Account;
import exceptions.RetrieveException;

public interface Transfer {
    void transferTo(Account c, double s) throws RetrieveException, RetrieveException;
}

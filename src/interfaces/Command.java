package interfaces;

import exceptions.AccountClosingException;
import exceptions.DeposeException;
import exceptions.RetrieveException;

public interface Command {
    void execute() throws DeposeException, RetrieveException, AccountClosingException;
}

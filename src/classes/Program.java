package classes;

import classes.GUI.MainWindow;
import classes.commanders.CloseAccountCommand;
import exceptions.AccountClosingException;
import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import interfaces.Command;

public class Program {
    public static void main(String[] args) throws DeposeException, IllegalAccountException, AccountClosingException, RetrieveException {
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}

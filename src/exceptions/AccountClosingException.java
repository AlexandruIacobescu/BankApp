package exceptions;

public class AccountClosingException extends Exception{
    public AccountClosingException(String exceptionMessage){
        super(exceptionMessage);
    }
}

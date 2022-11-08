package exceptions;

public class ExistingAccountException extends Exception {
    public ExistingAccountException(String exceptionMessage){
        super(exceptionMessage);
    }
}

package classes;

import exceptions.DeposeException;
import exceptions.IllegalAccountException;
import exceptions.RetrieveException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AccountRONTest {

    @Test
    public void createAccountRONWithNegativeAmount(){
        double amount = -98.0;
        IllegalAccountException exception = Assertions.assertThrows(IllegalAccountException.class, () -> {
            AccountRON account = new AccountRON("0000-0000-0000-0000", amount);
        });
        Assertions.assertEquals("Cannot create an account with a negative balance : " + amount, exception.getMessage());
    }

    @Test
    public void attemptToRetrieveMoreThanTheCurrentBalanceFromAccountRON(){
        double instanceAmount = 50;
        double retrieveAmount = 100;
        RetrieveException exception = Assertions.assertThrows(RetrieveException.class, () -> {
            AccountRON account = new AccountRON("0000-0000-0000-0000", instanceAmount);
            account.retrieve(retrieveAmount);
        });
        Assertions.assertEquals("Cannot retrieve more than the current balance : " + retrieveAmount, exception.getMessage());
    }

    @Test
    public void attemptToRetrieveANegativeAmountFromAccountRON(){
        double instanceAmount = 500;
        double amount = -100;
        RetrieveException exception = Assertions.assertThrows(RetrieveException.class, () -> {
            AccountRON account = new AccountRON("0000-0000-0000-0000", instanceAmount);
            account.retrieve(amount);
        });
        Assertions.assertEquals("Cannot retrieve a negative amount : " + amount, exception.getMessage());
    }

    @Test
    public void getTotalAmountTestFromAccountRON() throws DeposeException, IllegalAccountException {
        double requiredTotalAmountForUnder500 = 412;
        double requiredTotalAmountForOver500 = 648;
        double instanceAmountUnder500 = 400;
        double instanceAmountOver500 = 600;

        AccountRON account1 = new AccountRON("0000-0000-0000-0000", instanceAmountOver500);
        AccountRON account2 = new AccountRON("0000-0000-0000-0000", instanceAmountUnder500);
        Assertions.assertEquals(account1.getTotalAmount(), requiredTotalAmountForOver500);
        Assertions.assertEquals(account2.getTotalAmount(), requiredTotalAmountForUnder500);
    }

    @Test
    public void AccountRONTransferTest() throws DeposeException, IllegalAccountException, RetrieveException {
        AccountRON account1 = new AccountRON("0000-0000-0000-0000", 500);
        AccountRON account2 = new AccountRON("0000-0000-0000-0001", 1000);

        account1.transferTo(account2, 200);
        Assertions.assertEquals(1200 + 1200 * 0.08, account2.getTotalAmount());
        Assertions.assertEquals(300 + 300 * 0.03, account1.getTotalAmount());
    }
}
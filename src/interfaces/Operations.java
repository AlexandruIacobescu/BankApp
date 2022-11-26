package interfaces;

import exceptions.DeposeException;
import exceptions.RetrieveException;

public interface Operations {
    public double getTotalAmount();
    public double getInterest();
    public void depose(double amount) throws DeposeException;
    public void retrieve(double amount) throws RetrieveException;
}

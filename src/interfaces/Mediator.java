package interfaces;

import classes.Entity;

public interface Mediator {
    void send(String msg, Entity client);
}

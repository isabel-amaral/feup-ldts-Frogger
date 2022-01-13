package pt.up.fe.ldts.frogger;

import java.io.IOException;

public abstract class Command {
    public abstract Position execute(Position position);
}

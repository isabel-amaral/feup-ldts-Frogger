package pt.up.fe.ldts.frogger.element.command;

import pt.up.fe.ldts.frogger.Position;

public abstract class Command {
    public abstract Position execute(Position position);
}

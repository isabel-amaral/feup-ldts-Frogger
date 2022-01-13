package pt.up.fe.ldts.frogger;

public class MoveLeft extends Command{

    public Position execute(Position position) {
        return new Position(position.getX() - 1, position.getY());
    }
}
